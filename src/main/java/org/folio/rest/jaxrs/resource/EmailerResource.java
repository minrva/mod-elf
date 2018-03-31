
package org.folio.rest.jaxrs.resource;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import io.vertx.core.Context;
import org.folio.rest.annotations.Validate;
import org.folio.rest.jaxrs.model.Item_;
import org.folio.rest.jaxrs.model.PgPieces;
import org.folio.rest.jaxrs.model.PieceListCollection;


/**
 * Collection of emailer items.
 * 
 */
@Path("emailer")
public interface EmailerResource {


    /**
     * Retrieve a list of emailer items.
     * 
     * @param vertxContext
     *      The Vertx Context Object <code>io.vertx.core.Context</code> 
     * @param asyncResultHandler
     *     A <code>Handler<AsyncResult<Response>>></code> handler {@link io.vertx.core.Handler} which must be called as follows - Note the 'GetPatronsResponse' should be replaced with '[nameOfYourFunction]Response': (example only) <code>asyncResultHandler.handle(io.vertx.core.Future.succeededFuture(GetPatronsResponse.withJsonOK( new ObjectMapper().readValue(reply.result().body().toString(), Patron.class))));</code> in the final callback (most internal callback) of the function.
     * @param lang
     *     Requested language. Optional. [lang=en]
     *     
     */
    @GET
    @Produces({
        "application/json",
        "text/plain"
    })
    @Validate
    void getEmailer(
        @QueryParam("lang")
        @DefaultValue("en")
        @Pattern(regexp = "[a-zA-Z]{2}")
        String lang, java.util.Map<String, String>okapiHeaders, io.vertx.core.Handler<io.vertx.core.AsyncResult<Response>>asyncResultHandler, Context vertxContext)
        throws Exception
    ;

    /**
     * Create a new emailer item.
     * 
     * @param vertxContext
     *      The Vertx Context Object <code>io.vertx.core.Context</code> 
     * @param asyncResultHandler
     *     A <code>Handler<AsyncResult<Response>>></code> handler {@link io.vertx.core.Handler} which must be called as follows - Note the 'GetPatronsResponse' should be replaced with '[nameOfYourFunction]Response': (example only) <code>asyncResultHandler.handle(io.vertx.core.Future.succeededFuture(GetPatronsResponse.withJsonOK( new ObjectMapper().readValue(reply.result().body().toString(), Patron.class))));</code> in the final callback (most internal callback) of the function.
     * @param lang
     *     Requested language. Optional. [lang=en]
     *     
     * @param entity
     *      e.g. {
     *         "id": "0",
     *         "itemid": "23fdb0bc-ab58-442a-b326-577a96204487",
     *         "email": "ben@gmail.com",
     *         "itemname": "Asus Tablet",
     *         "returnday": "October 2nd, 2018",
     *         "returntime": "11:00 PM",
     *         "pdf": "jfioewjfjeio",
     *         "piece_list": [
     *         "Mini DisplayPort to VGA Adapter."
     *         ]
     *     }
     */
    @POST
    @Consumes("application/json")
    @Produces({
        "application/json",
        "text/plain"
    })
    @Validate
    void postEmailer(
        @QueryParam("lang")
        @DefaultValue("en")
        @Pattern(regexp = "[a-zA-Z]{2}")
        String lang, Item_ entity, java.util.Map<String, String>okapiHeaders, io.vertx.core.Handler<io.vertx.core.AsyncResult<Response>>asyncResultHandler, Context vertxContext)
        throws Exception
    ;

    /**
     * Retrieve emailer item with given {emailerId}
     * 
     * 
     * @param itemId
     *     
     * @param vertxContext
     *      The Vertx Context Object <code>io.vertx.core.Context</code> 
     * @param asyncResultHandler
     *     A <code>Handler<AsyncResult<Response>>></code> handler {@link io.vertx.core.Handler} which must be called as follows - Note the 'GetPatronsResponse' should be replaced with '[nameOfYourFunction]Response': (example only) <code>asyncResultHandler.handle(io.vertx.core.Future.succeededFuture(GetPatronsResponse.withJsonOK( new ObjectMapper().readValue(reply.result().body().toString(), Patron.class))));</code> in the final callback (most internal callback) of the function.
     * @param lang
     *     Requested language. Optional. [lang=en]
     *     
     */
    @GET
    @Path("{itemId}")
    @Produces({
        "application/json",
        "text/plain"
    })
    @Validate
    void getEmailerByItemId(
        @PathParam("itemId")
        @NotNull
        String itemId,
        @QueryParam("lang")
        @DefaultValue("en")
        @Pattern(regexp = "[a-zA-Z]{2}")
        String lang, java.util.Map<String, String>okapiHeaders, io.vertx.core.Handler<io.vertx.core.AsyncResult<Response>>asyncResultHandler, Context vertxContext)
        throws Exception
    ;

    /**
     * Delete emailer item with given {emailerId}
     * 
     * 
     * @param itemId
     *     
     * @param vertxContext
     *      The Vertx Context Object <code>io.vertx.core.Context</code> 
     * @param asyncResultHandler
     *     A <code>Handler<AsyncResult<Response>>></code> handler {@link io.vertx.core.Handler} which must be called as follows - Note the 'GetPatronsResponse' should be replaced with '[nameOfYourFunction]Response': (example only) <code>asyncResultHandler.handle(io.vertx.core.Future.succeededFuture(GetPatronsResponse.withJsonOK( new ObjectMapper().readValue(reply.result().body().toString(), Patron.class))));</code> in the final callback (most internal callback) of the function.
     * @param lang
     *     Requested language. Optional. [lang=en]
     *     
     */
    @DELETE
    @Path("{itemId}")
    @Produces({
        "text/plain"
    })
    @Validate
    void deleteEmailerByItemId(
        @PathParam("itemId")
        @NotNull
        String itemId,
        @QueryParam("lang")
        @DefaultValue("en")
        @Pattern(regexp = "[a-zA-Z]{2}")
        String lang, java.util.Map<String, String>okapiHeaders, io.vertx.core.Handler<io.vertx.core.AsyncResult<Response>>asyncResultHandler, Context vertxContext)
        throws Exception
    ;

    /**
     * Update emailer item with given {emailerId}
     * 
     * 
     * @param itemId
     *     
     * @param vertxContext
     *      The Vertx Context Object <code>io.vertx.core.Context</code> 
     * @param asyncResultHandler
     *     A <code>Handler<AsyncResult<Response>>></code> handler {@link io.vertx.core.Handler} which must be called as follows - Note the 'GetPatronsResponse' should be replaced with '[nameOfYourFunction]Response': (example only) <code>asyncResultHandler.handle(io.vertx.core.Future.succeededFuture(GetPatronsResponse.withJsonOK( new ObjectMapper().readValue(reply.result().body().toString(), Patron.class))));</code> in the final callback (most internal callback) of the function.
     * @param lang
     *     Requested language. Optional. [lang=en]
     *     
     * @param entity
     *      e.g. {
     *         "id": "0",
     *         "itemid": "23fdb0bc-ab58-442a-b326-577a96204487",
     *         "piece_list": [
     *         "Mini DisplayPort to VGA Adapter."
     *         ]
     *     }
     */
    @PUT
    @Path("{itemId}")
    @Consumes("application/json")
    @Produces({
        "text/plain"
    })
    @Validate
    void putEmailerByItemId(
        @PathParam("itemId")
        @NotNull
        String itemId,
        @QueryParam("lang")
        @DefaultValue("en")
        @Pattern(regexp = "[a-zA-Z]{2}")
        String lang, PgPieces entity, java.util.Map<String, String>okapiHeaders, io.vertx.core.Handler<io.vertx.core.AsyncResult<Response>>asyncResultHandler, Context vertxContext)
        throws Exception
    ;

    public class DeleteEmailerByItemIdResponse
        extends org.folio.rest.jaxrs.resource.support.ResponseWrapper
    {


        private DeleteEmailerByItemIdResponse(Response delegate) {
            super(delegate);
        }

        /**
         * Item deleted successfully
         * 
         */
        public static EmailerResource.DeleteEmailerByItemIdResponse withNoContent() {
            Response.ResponseBuilder responseBuilder = Response.status(204);
            return new EmailerResource.DeleteEmailerByItemIdResponse(responseBuilder.build());
        }

        /**
         * Item with a given ID not found e.g. "emailer not found"
         * 
         * 
         * @param entity
         *     "emailer not found"
         *     
         */
        public static EmailerResource.DeleteEmailerByItemIdResponse withPlainNotFound(String entity) {
            Response.ResponseBuilder responseBuilder = Response.status(404).header("Content-Type", "text/plain");
            responseBuilder.entity(entity);
            return new EmailerResource.DeleteEmailerByItemIdResponse(responseBuilder.build());
        }

        /**
         * Bad request, e.g. malformed request body or query parameter. Details of the error (e.g. name of the parameter or line/character number with malformed data) provided in the response. e.g. "unable to delete emailer -- constraint violation"
         * 
         * 
         * @param entity
         *     "unable to delete emailer -- constraint violation"
         *     
         */
        public static EmailerResource.DeleteEmailerByItemIdResponse withPlainBadRequest(String entity) {
            Response.ResponseBuilder responseBuilder = Response.status(400).header("Content-Type", "text/plain");
            responseBuilder.entity(entity);
            return new EmailerResource.DeleteEmailerByItemIdResponse(responseBuilder.build());
        }

        /**
         * Internal server error, e.g. due to misconfiguration e.g. Internal server error, contact administrator
         * 
         * @param entity
         *     Internal server error, contact administrator
         */
        public static EmailerResource.DeleteEmailerByItemIdResponse withPlainInternalServerError(String entity) {
            Response.ResponseBuilder responseBuilder = Response.status(500).header("Content-Type", "text/plain");
            responseBuilder.entity(entity);
            return new EmailerResource.DeleteEmailerByItemIdResponse(responseBuilder.build());
        }

    }

    public class GetEmailerByItemIdResponse
        extends org.folio.rest.jaxrs.resource.support.ResponseWrapper
    {


        private GetEmailerByItemIdResponse(Response delegate) {
            super(delegate);
        }

        /**
         * Returns item with a given ID e.g. {
         *     "id": "0",
         *     "itemid": "23fdb0bc-ab58-442a-b326-577a96204487",
         *     "piece_list": [
         *     "Mini DisplayPort to VGA Adapter."
         *     ]
         * }
         * 
         * @param entity
         *     {
         *         "id": "0",
         *         "itemid": "23fdb0bc-ab58-442a-b326-577a96204487",
         *         "piece_list": [
         *         "Mini DisplayPort to VGA Adapter."
         *         ]
         *     }
         */
        public static EmailerResource.GetEmailerByItemIdResponse withJsonOK(PgPieces entity) {
            Response.ResponseBuilder responseBuilder = Response.status(200).header("Content-Type", "application/json");
            responseBuilder.entity(entity);
            return new EmailerResource.GetEmailerByItemIdResponse(responseBuilder.build());
        }

        /**
         * Item with a given ID not found e.g. "emailer not found"
         * 
         * 
         * @param entity
         *     "emailer not found"
         *     
         */
        public static EmailerResource.GetEmailerByItemIdResponse withPlainNotFound(String entity) {
            Response.ResponseBuilder responseBuilder = Response.status(404).header("Content-Type", "text/plain");
            responseBuilder.entity(entity);
            return new EmailerResource.GetEmailerByItemIdResponse(responseBuilder.build());
        }

        /**
         * Internal server error, e.g. due to misconfiguration e.g. internal server error, contact administrator
         * 
         * @param entity
         *     internal server error, contact administrator
         */
        public static EmailerResource.GetEmailerByItemIdResponse withPlainInternalServerError(String entity) {
            Response.ResponseBuilder responseBuilder = Response.status(500).header("Content-Type", "text/plain");
            responseBuilder.entity(entity);
            return new EmailerResource.GetEmailerByItemIdResponse(responseBuilder.build());
        }

    }

    public class GetEmailerResponse
        extends org.folio.rest.jaxrs.resource.support.ResponseWrapper
    {


        private GetEmailerResponse(Response delegate) {
            super(delegate);
        }

        /**
         * Returns a list of emailer items e.g. {
         *   "iteminfo": [
         *     {
         * 			"id": "0",
         * 			"itemid": "23fdb0bc-ab58-442a-b326-577a96204487",
         * 			"email": "ben@gmail.com",
         * 			"itemname": "Asus Tablet",
         * 			"returnday": "October 2nd, 2018",
         * 			"returntime": "11:00 PM",
         * 			"pdf": "jfioewjfjeio",
         * 			"piece_list": [
         * 			"Mini DisplayPort to VGA Adapter."
         * 		]
         * 		},
         * 		{
         * 		"id": "1",
         * 		"itemid": "81335b5b-84f2-4e1a-b154-b010978cd09b",
         * 		"email": "ben@gmail.com",
         * 		"itemname": "Projector",
         * 		"returnday": "October 2nd, 2018",
         * 		"returntime": "11:00 PM",
         * 		"pdf": "jfioewjfjeio",
         * 		"piece_list": [
         * 		"Projector (main unit)",
         * 		"Power cable",
         * 		"VGA cable",
         * 		"HDMI cable",
         * 		"Headphone cable",
         * 		"Remote control",
         * 		"Apple mini displayport to VGA adapter",
         * 		"Quick start guide."
         * 		]
         * 		}
         *   ],
         *   "total_records": 2
         * }
         * 
         * 
         * @param entity
         *     {
         *       "iteminfo": [
         *         {
         *     			"id": "0",
         *     			"itemid": "23fdb0bc-ab58-442a-b326-577a96204487",
         *     			"email": "ben@gmail.com",
         *     			"itemname": "Asus Tablet",
         *     			"returnday": "October 2nd, 2018",
         *     			"returntime": "11:00 PM",
         *     			"pdf": "jfioewjfjeio",
         *     			"piece_list": [
         *     			"Mini DisplayPort to VGA Adapter."
         *     		]
         *     		},
         *     		{
         *     		"id": "1",
         *     		"itemid": "81335b5b-84f2-4e1a-b154-b010978cd09b",
         *     		"email": "ben@gmail.com",
         *     		"itemname": "Projector",
         *     		"returnday": "October 2nd, 2018",
         *     		"returntime": "11:00 PM",
         *     		"pdf": "jfioewjfjeio",
         *     		"piece_list": [
         *     		"Projector (main unit)",
         *     		"Power cable",
         *     		"VGA cable",
         *     		"HDMI cable",
         *     		"Headphone cable",
         *     		"Remote control",
         *     		"Apple mini displayport to VGA adapter",
         *     		"Quick start guide."
         *     		]
         *     		}
         *       ],
         *       "total_records": 2
         *     }
         *     
         */
        public static EmailerResource.GetEmailerResponse withJsonOK(PieceListCollection entity) {
            Response.ResponseBuilder responseBuilder = Response.status(200).header("Content-Type", "application/json");
            responseBuilder.entity(entity);
            return new EmailerResource.GetEmailerResponse(responseBuilder.build());
        }

        /**
         * Bad request, e.g. malformed request body or query parameter. Details of the error (e.g. name of the parameter or line/character number with malformed data) provided in the response. e.g. unable to list emailer -- malformed parameter 'query', syntax error at column 6
         * 
         * @param entity
         *     unable to list emailer -- malformed parameter 'query', syntax error at column 6
         */
        public static EmailerResource.GetEmailerResponse withPlainBadRequest(String entity) {
            Response.ResponseBuilder responseBuilder = Response.status(400).header("Content-Type", "text/plain");
            responseBuilder.entity(entity);
            return new EmailerResource.GetEmailerResponse(responseBuilder.build());
        }

        /**
         * Not authorized to perform requested action e.g. unable to list emailer -- unauthorized
         * 
         * @param entity
         *     unable to list emailer -- unauthorized
         */
        public static EmailerResource.GetEmailerResponse withPlainUnauthorized(String entity) {
            Response.ResponseBuilder responseBuilder = Response.status(401).header("Content-Type", "text/plain");
            responseBuilder.entity(entity);
            return new EmailerResource.GetEmailerResponse(responseBuilder.build());
        }

        /**
         * Internal server error, e.g. due to misconfiguration e.g. internal server error, contact administrator
         * 
         * @param entity
         *     internal server error, contact administrator
         */
        public static EmailerResource.GetEmailerResponse withPlainInternalServerError(String entity) {
            Response.ResponseBuilder responseBuilder = Response.status(500).header("Content-Type", "text/plain");
            responseBuilder.entity(entity);
            return new EmailerResource.GetEmailerResponse(responseBuilder.build());
        }

    }

    public class PostEmailerResponse
        extends org.folio.rest.jaxrs.resource.support.ResponseWrapper
    {


        private PostEmailerResponse(Response delegate) {
            super(delegate);
        }

        /**
         * Returns a newly created item, with server-controlled fields like 'id' populated e.g. {
         *     "id": "0",
         *     "itemid": "23fdb0bc-ab58-442a-b326-577a96204487",
         *     "email": "ben@gmail.com",
         *     "itemname": "Asus Tablet",
         *     "returnday": "October 2nd, 2018",
         *     "returntime": "11:00 PM",
         *     "pdf": "jfioewjfjeio",
         *     "piece_list": [
         *     "Mini DisplayPort to VGA Adapter."
         *     ]
         * }
         * 
         * @param location
         *     URI to the created emailer item
         * @param entity
         *     {
         *         "id": "0",
         *         "itemid": "23fdb0bc-ab58-442a-b326-577a96204487",
         *         "email": "ben@gmail.com",
         *         "itemname": "Asus Tablet",
         *         "returnday": "October 2nd, 2018",
         *         "returntime": "11:00 PM",
         *         "pdf": "jfioewjfjeio",
         *         "piece_list": [
         *         "Mini DisplayPort to VGA Adapter."
         *         ]
         *     }
         */
        public static EmailerResource.PostEmailerResponse withJsonCreated(String location, StreamingOutput entity) {
            Response.ResponseBuilder responseBuilder = Response.status(201).header("Content-Type", "application/json").header("Location", location);
            responseBuilder.entity(entity);
            return new EmailerResource.PostEmailerResponse(responseBuilder.build());
        }

        /**
         * Bad request, e.g. malformed request body or query parameter. Details of the error (e.g. name of the parameter or line/character number with malformed data) provided in the response. e.g. "unable to add emailer -- malformed JSON at 13:3"
         * 
         * 
         * @param entity
         *     "unable to add emailer -- malformed JSON at 13:3"
         *     
         */
        public static EmailerResource.PostEmailerResponse withPlainBadRequest(String entity) {
            Response.ResponseBuilder responseBuilder = Response.status(400).header("Content-Type", "text/plain");
            responseBuilder.entity(entity);
            return new EmailerResource.PostEmailerResponse(responseBuilder.build());
        }

        /**
         * Not authorized to perform requested action e.g. unable to create emailer -- unauthorized
         * 
         * @param entity
         *     unable to create emailer -- unauthorized
         */
        public static EmailerResource.PostEmailerResponse withPlainUnauthorized(String entity) {
            Response.ResponseBuilder responseBuilder = Response.status(401).header("Content-Type", "text/plain");
            responseBuilder.entity(entity);
            return new EmailerResource.PostEmailerResponse(responseBuilder.build());
        }

        /**
         * Internal server error, e.g. due to misconfiguration e.g. Internal server error, contact administrator
         * 
         * @param entity
         *     Internal server error, contact administrator
         */
        public static EmailerResource.PostEmailerResponse withPlainInternalServerError(String entity) {
            Response.ResponseBuilder responseBuilder = Response.status(500).header("Content-Type", "text/plain");
            responseBuilder.entity(entity);
            return new EmailerResource.PostEmailerResponse(responseBuilder.build());
        }

    }

    public class PutEmailerByItemIdResponse
        extends org.folio.rest.jaxrs.resource.support.ResponseWrapper
    {


        private PutEmailerByItemIdResponse(Response delegate) {
            super(delegate);
        }

        /**
         * Item successfully updated
         * 
         */
        public static EmailerResource.PutEmailerByItemIdResponse withNoContent() {
            Response.ResponseBuilder responseBuilder = Response.status(204);
            return new EmailerResource.PutEmailerByItemIdResponse(responseBuilder.build());
        }

        /**
         * Item with a given ID not found e.g. "emailer not found"
         * 
         * 
         * @param entity
         *     "emailer not found"
         *     
         */
        public static EmailerResource.PutEmailerByItemIdResponse withPlainNotFound(String entity) {
            Response.ResponseBuilder responseBuilder = Response.status(404).header("Content-Type", "text/plain");
            responseBuilder.entity(entity);
            return new EmailerResource.PutEmailerByItemIdResponse(responseBuilder.build());
        }

        /**
         * Bad request, e.g. malformed request body or query parameter. Details of the error (e.g. name of the parameter or line/character number with malformed data) provided in the response. e.g. "unable to update emailer -- malformed JSON at 13:4"
         * 
         * 
         * @param entity
         *     "unable to update emailer -- malformed JSON at 13:4"
         *     
         */
        public static EmailerResource.PutEmailerByItemIdResponse withPlainBadRequest(String entity) {
            Response.ResponseBuilder responseBuilder = Response.status(400).header("Content-Type", "text/plain");
            responseBuilder.entity(entity);
            return new EmailerResource.PutEmailerByItemIdResponse(responseBuilder.build());
        }

        /**
         * Internal server error, e.g. due to misconfiguration e.g. internal server error, contact administrator
         * 
         * @param entity
         *     internal server error, contact administrator
         */
        public static EmailerResource.PutEmailerByItemIdResponse withPlainInternalServerError(String entity) {
            Response.ResponseBuilder responseBuilder = Response.status(500).header("Content-Type", "text/plain");
            responseBuilder.entity(entity);
            return new EmailerResource.PutEmailerByItemIdResponse(responseBuilder.build());
        }

    }

}
