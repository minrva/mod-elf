package org.folio.rest.impl;

import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.folio.rest.jaxrs.model.Item;
import org.folio.rest.jaxrs.model.ItemInfoCollection;
import org.folio.rest.jaxrs.resource.IteminfoResource;
import org.folio.rest.persist.PostgresClient;
import org.folio.rest.utils.PgQuery;

import io.vertx.core.AsyncResult;
import io.vertx.core.Context;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;

public class ItemInfoAPI implements IteminfoResource {

	private final PostgresClient pgClient;

	private static final String[] ALL_FIELDS = { "*" };
	private static final String DEFAULT_TABLE = "items";

	public ItemInfoAPI(Vertx vertx, String tenantId) {
		this.pgClient = PostgresClient.getInstance(vertx, tenantId);
		this.pgClient.setIdField("id");
	}

	@Override
	public void getIteminfo(String query, int offset, int limit, String lang, Map<String, String> okapiHeaders,
			Handler<AsyncResult<Response>> asyncResultHandler, Context vertxContext) throws Exception {
		PgQuery pgQuery = new PgQuery.PgQueryBuilder(ALL_FIELDS, DEFAULT_TABLE)
			.query(query)
			.offset(offset)
			.limit(limit)
			.build();
		Future.succeededFuture(pgQuery)
			.compose(this::runQuery)
			.compose(this::parseGetResults)
			.setHandler(asyncResultHandler);
	}

	private Future<Object[]> runQuery(PgQuery query) {
		Future<Object[]> future = Future.future();
		try {
			pgClient.get(query.getTable(), Item.class, query.getFields(), query.getCql(), true, false,
					future.completer());
		} catch (Exception e) {
			e.printStackTrace();
			future.fail(new Throwable(e));
		}
		return future;
	}

	@SuppressWarnings("unchecked")
	public Future<Response> parseGetResults(Object[] resultSet) {
		List<Item> itemList = (List<Item>) resultSet[0];
		int totalRecords = (Integer) resultSet[1];
		ItemInfoCollection itemInfoCollection = new ItemInfoCollection();
		itemInfoCollection.setItems(itemList);
		itemInfoCollection.setTotalRecords(totalRecords);
		Response getItemInfoResponse = GetIteminfoResponse.withJsonOK(itemInfoCollection);
		return Future.succeededFuture(getItemInfoResponse);
	}

	@Override
	public void postIteminfo(String query, int offset, int limit, String lang, Item entity,
			Map<String, String> okapiHeaders, Handler<AsyncResult<Response>> asyncResultHandler, Context vertxContext)
			throws Exception {
		throw new Exception("postIteminfo not implemented.");
	}
}
