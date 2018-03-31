package org.folio.rest.impl;

import java.util.Map;

import javax.mail.Message;
import javax.mail.Transport;
import javax.ws.rs.core.Response;

import org.folio.rest.jaxrs.model.Item__;
import org.folio.rest.jaxrs.resource.EmailreturnResource;
import org.folio.rest.persist.PostgresClient;
import org.folio.rest.persist.Criteria.Criteria;
import org.folio.rest.persist.Criteria.Criterion;
import org.folio.rest.utils.EmailComposer;
import org.folio.rest.tools.utils.TenantTool;

import io.vertx.core.AsyncResult;
import io.vertx.core.Context;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;

public class EmailerReturnAPI implements EmailreturnResource {
	private final PostgresClient pgClient;

	public EmailerReturnAPI(Vertx vertx, String tenantId) {
		this.pgClient = PostgresClient.getInstance(vertx, tenantId);
		this.pgClient.setIdField("id");
	}

	@Override
	public void deleteEmailreturn(String lang, Map<String, String> okapiHeaders,
			Handler<AsyncResult<Response>> asyncResultHandler, Context vertxContext) throws Exception {
		throw new Exception("deleteEmailreturn not implemented.");
	}

	@Override
	public void getEmailreturn(String lang, Map<String, String> okapiHeaders,
			Handler<AsyncResult<Response>> asyncResultHandler, Context vertxContext) throws Exception {
		throw new Exception("getEmailreturn not implemented.");
	}

	@Override
	public void postEmailreturn(String lang, Item__ entity, Map<String, String> okapiHeaders,
			Handler<AsyncResult<Response>> asyncResultHandler, Context vertxContext) throws Exception {
		try {
			EmailComposer composer = new EmailComposer();
			Message message = composer.composeCheckinEmail(entity.getEmail(), entity.getItemname(), entity.getPdf());
			Transport.send(message);
			vertxContext.runOnContext(v -> {
				String tenantId = TenantTool.calculateTenantId(okapiHeaders.get("x-okapi-tenant"));
				Criteria idCrit = new Criteria();
				idCrit.addField("'id'");
				idCrit.setOperation("=");
				idCrit.setValue(entity.getItemid());
				try {
					PostgresClient.getInstance(vertxContext.owner(), tenantId).delete("emailer", new Criterion(idCrit),
							deleteReply -> {
								if (deleteReply.failed()) {
									asyncResultHandler.handle(Future
											.succeededFuture(PostEmailreturnResponse.withPlainBadRequest("Not found")));
								} else {
									asyncResultHandler.handle(Future
											.succeededFuture(PostEmailreturnResponse.withJsonCreated(null, null)));
								}
							});
				} catch (Exception e) {
					e.printStackTrace();
					asyncResultHandler.handle(Future
							.succeededFuture(PostEmailreturnResponse.withPlainInternalServerError("Server Error")));
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			asyncResultHandler.handle(
					Future.succeededFuture(PostEmailreturnResponse.withPlainInternalServerError("Server Error")));
		}
	}
}
