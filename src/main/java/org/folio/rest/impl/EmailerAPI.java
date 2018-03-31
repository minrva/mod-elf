package org.folio.rest.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.mail.Message;
import javax.mail.Transport;
import javax.ws.rs.core.Response;

import org.folio.rest.jaxrs.model.Item_;
import org.folio.rest.jaxrs.model.PgPieces;
import org.folio.rest.jaxrs.resource.EmailerResource;
import org.folio.rest.persist.PostgresClient;
import org.folio.rest.utils.EmailComposer;
import org.folio.rest.tools.utils.OutStream;
import org.folio.rest.utils.EmailTransaction;
import org.folio.rest.utils.PgQuery;
import org.folio.rest.utils.PgTransaction;

import io.vertx.core.AsyncResult;
import io.vertx.core.Context;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;

public class EmailerAPI implements EmailerResource {
	private final PostgresClient pgClient;

	private static final String[] ALL_FIELDS = { "*" };
	private static final String DEFAULT_TABLE = "emailer";

	public EmailerAPI(Vertx vertx, String tenantId) {
		this.pgClient = PostgresClient.getInstance(vertx, tenantId);
		this.pgClient.setIdField("id");
	}

	private Future<EmailTransaction> sendEmail(EmailTransaction emailTx) {
		Future<EmailTransaction> future = Future.future();
		try {
			EmailComposer composer = new EmailComposer();
			Message message = composer.composeCheckout(emailTx);
			Transport.send(message);
			future.complete(emailTx);
		} catch (Exception e) {
			future.fail(new Throwable(e));
		}
		return future;
	}

	private Future<EmailTransaction> startTx(EmailTransaction emailTx) {
		Future<EmailTransaction> future = Future.future();
		pgClient.startTx(sqlConnection -> {
			emailTx.tx.sqlConnection = sqlConnection;
			future.complete(emailTx);
		});
		return future;
	}

	private Future<EmailTransaction> saveItems(EmailTransaction emailTx) {
		Future<EmailTransaction> future = Future.future();
		try {
			pgClient.save(emailTx.tx.sqlConnection, DEFAULT_TABLE, emailTx.tx.entity, location -> {
				emailTx.tx.location = location;
				future.complete(emailTx);
			});
		} catch (Exception e) {
			future.fail(new Throwable(e));
		}
		return future;
	}

	private Future<EmailTransaction> endTx(EmailTransaction emailTx) {
		Future<EmailTransaction> future = Future.future();
		pgClient.endTx(emailTx.tx.sqlConnection, v -> {
			future.complete(emailTx);
		});
		return future;
	}

	private Future<Response> parsePostResults(EmailTransaction emailTx) {
		final String location = emailTx.tx.location.result();
		final PgPieces pgPieces = emailTx.tx.entity;
		pgPieces.setId(emailTx.tx.entity.getId());
		OutStream entity = new OutStream();
		entity.setData(pgPieces);
		Response response = PostEmailerResponse.withJsonCreated(location, entity);
		return Future.succeededFuture(response);
	}

	@Override
	public void postEmailer(String lang, Item_ entity, Map<String, String> okapiHeaders,
			Handler<AsyncResult<Response>> asyncResultHandler, Context vertxContext) throws Exception {
		List<String> stringArray = entity.getPieceList();
		ArrayList<String> pieceListArray = new ArrayList<String>(stringArray);
		PgPieces pgPieces = new PgPieces();
		pgPieces.setId(entity.getId());
		pgPieces.setItemid(entity.getItemid());
		pgPieces.setPieceList(pieceListArray);
		PgTransaction<PgPieces> pgTransaction = new PgTransaction<PgPieces>(pgPieces);
		EmailTransaction emailTx = new EmailTransaction(entity.getEmail(), entity.getItemname(), entity.getReturnday(),
				entity.getReturntime(), entity.getPdf(), pgTransaction);
		Future.succeededFuture(emailTx)
			.compose(this::sendEmail)
			.compose(this::startTx)
			.compose(this::saveItems)
			.compose(this::endTx)
			.compose(this::parsePostResults)
			.setHandler(asyncResultHandler);
	}

	private Future<Object[]> runQuery(PgQuery query) {
		Future<Object[]> future = Future.future();
		try {
			pgClient.get(query.getTable(), PgPieces.class, query.getFields(), query.getCql(), true, false,
					future.completer());
		} catch (Exception e) {
			future.fail(new Throwable(e));
		}
		return future;
	}

	@SuppressWarnings("unchecked")
	public Future<Response> parseGetResults(Object[] resultSet) {
		List<PgPieces> pgPiecesList = (List<PgPieces>) resultSet[0];
		PgPieces pgPiece = pgPiecesList.get(0);
		Response getWaitlistsResponse = GetEmailerByItemIdResponse.withJsonOK(pgPiece);
		return Future.succeededFuture(getWaitlistsResponse);
	}

	@Override
	public void getEmailer(String lang, Map<String, String> okapiHeaders,
			Handler<AsyncResult<Response>> asyncResultHandler, Context vertxContext) throws Exception {
		throw new Exception("getEmailer not implemented.");
	}

	@Override
	public void getEmailerByItemId(String itemId, String lang, Map<String, String> okapiHeaders,
			Handler<AsyncResult<Response>> asyncResultHandler, Context vertxContext) throws Exception {
		String query = String.format("query=itemid=%s", itemId);
		PgQuery pgQuery = new PgQuery.PgQueryBuilder(ALL_FIELDS, DEFAULT_TABLE).query(query).offset(0).limit(1).build();
		Future.succeededFuture(pgQuery)
			.compose(this::runQuery)
			.compose(this::parseGetResults)
			.setHandler(asyncResultHandler);
	}

	@Override
	public void putEmailerByItemId(String itemId, String lang, PgPieces entity, Map<String, String> okapiHeaders,
			Handler<AsyncResult<Response>> asyncResultHandler, Context vertxContext) throws Exception {
		throw new Exception("putEmailerByItemId not implemented.");
	}

	@Override
	public void deleteEmailerByItemId(String itemId, String lang, Map<String, String> okapiHeaders,
			Handler<AsyncResult<Response>> asyncResultHandler, Context vertxContext) throws Exception {
		throw new Exception("deleteEmailerByItemId not implemented.");
	}
}
