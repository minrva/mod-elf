
package org.folio.rest.jaxrs.resource;

import javax.validation.constraints.Pattern;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import io.vertx.core.Context;
import org.folio.rest.annotations.Validate;
import org.folio.rest.jaxrs.model.EmailReturnCollection;
import org.folio.rest.jaxrs.model.Item__;


/**
 * Collection of emailreturn items.
 * 
 */
@Path("emailreturn")
public interface EmailreturnResource {


    /**
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
    @Validate
    void deleteEmailreturn(
        @QueryParam("lang")
        @DefaultValue("en")
        @Pattern(regexp = "[a-zA-Z]{2}")
        String lang, java.util.Map<String, String>okapiHeaders, io.vertx.core.Handler<io.vertx.core.AsyncResult<Response>>asyncResultHandler, Context vertxContext)
        throws Exception
    ;

    /**
     * Retrieve a list of emailreturn items.
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
    void getEmailreturn(
        @QueryParam("lang")
        @DefaultValue("en")
        @Pattern(regexp = "[a-zA-Z]{2}")
        String lang, java.util.Map<String, String>okapiHeaders, io.vertx.core.Handler<io.vertx.core.AsyncResult<Response>>asyncResultHandler, Context vertxContext)
        throws Exception
    ;

    /**
     * Create a new emailreturn item.
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
     *         "id": "23fdb0bc-ab58-442a-b326-577a96204487",
     *         "itemid": "23fdb0bc-ab58-442a-b326-577a96204487",
     *         "email": "ben@gmail.com",
     *         "itemname": "Asus Tablet",
     *         "pdf": "jfioewjfjeio"
     *     }
     */
    @POST
    @Consumes("application/json")
    @Produces({
        "application/json",
        "text/plain"
    })
    @Validate
    void postEmailreturn(
        @QueryParam("lang")
        @DefaultValue("en")
        @Pattern(regexp = "[a-zA-Z]{2}")
        String lang, Item__ entity, java.util.Map<String, String>okapiHeaders, io.vertx.core.Handler<io.vertx.core.AsyncResult<Response>>asyncResultHandler, Context vertxContext)
        throws Exception
    ;

    public class DeleteEmailreturnResponse
        extends org.folio.rest.jaxrs.resource.support.ResponseWrapper
    {


        private DeleteEmailreturnResponse(Response delegate) {
            super(delegate);
        }

    }

    public class GetEmailreturnResponse
        extends org.folio.rest.jaxrs.resource.support.ResponseWrapper
    {


        private GetEmailreturnResponse(Response delegate) {
            super(delegate);
        }

        /**
         * Returns a list of emailreturn items e.g. {
         *     "emailreturn": [
         *       {
         *             "id": "23fdb0bc-ab58-442a-b326-577a96204487",
         *             "itemid": "23fdb0bc-ab58-442a-b326-577a96204487",
         *             "email": "ben@gmail.com",
         *             "itemname": "Asus Tablet",
         *             "pdf": "jfioewjfjeio"
         *         },
         *         {
         *             "id": "23fdb0bc-ab58-442a-b326-577a96204487",
         *             "itemid": "23fdb0bc-ab58-442a-b326-577a96204487",
         *             "email": "ben@gmail.com",
         *             "itemname": "Asus Tablet",
         *             "pdf": "jfioewjfjeio"
         *         }
         *     ],
         *     "total_records": 2
         *   }
         * 
         * @param entity
         *     {
         *         "emailreturn": [
         *           {
         *                 "id": "23fdb0bc-ab58-442a-b326-577a96204487",
         *                 "itemid": "23fdb0bc-ab58-442a-b326-577a96204487",
         *                 "email": "ben@gmail.com",
         *                 "itemname": "Asus Tablet",
         *                 "pdf": "jfioewjfjeio"
         *             },
         *             {
         *                 "id": "23fdb0bc-ab58-442a-b326-577a96204487",
         *                 "itemid": "23fdb0bc-ab58-442a-b326-577a96204487",
         *                 "email": "ben@gmail.com",
         *                 "itemname": "Asus Tablet",
         *                 "pdf": "jfioewjfjeio"
         *             }
         *         ],
         *         "total_records": 2
         *       }
         */
        public static EmailreturnResource.GetEmailreturnResponse withJsonOK(EmailReturnCollection entity) {
            Response.ResponseBuilder responseBuilder = Response.status(200).header("Content-Type", "application/json");
            responseBuilder.entity(entity);
            return new EmailreturnResource.GetEmailreturnResponse(responseBuilder.build());
        }

        /**
         * Bad request, e.g. malformed request body or query parameter. Details of the error (e.g. name of the parameter or line/character number with malformed data) provided in the response. e.g. unable to list emailreturn -- malformed parameter 'query', syntax error at column 6
         * 
         * @param entity
         *     unable to list emailreturn -- malformed parameter 'query', syntax error at column 6
         */
        public static EmailreturnResource.GetEmailreturnResponse withPlainBadRequest(String entity) {
            Response.ResponseBuilder responseBuilder = Response.status(400).header("Content-Type", "text/plain");
            responseBuilder.entity(entity);
            return new EmailreturnResource.GetEmailreturnResponse(responseBuilder.build());
        }

        /**
         * Not authorized to perform requested action e.g. unable to list emailreturn -- unauthorized
         * 
         * @param entity
         *     unable to list emailreturn -- unauthorized
         */
        public static EmailreturnResource.GetEmailreturnResponse withPlainUnauthorized(String entity) {
            Response.ResponseBuilder responseBuilder = Response.status(401).header("Content-Type", "text/plain");
            responseBuilder.entity(entity);
            return new EmailreturnResource.GetEmailreturnResponse(responseBuilder.build());
        }

        /**
         * Internal server error, e.g. due to misconfiguration e.g. internal server error, contact administrator
         * 
         * @param entity
         *     internal server error, contact administrator
         */
        public static EmailreturnResource.GetEmailreturnResponse withPlainInternalServerError(String entity) {
            Response.ResponseBuilder responseBuilder = Response.status(500).header("Content-Type", "text/plain");
            responseBuilder.entity(entity);
            return new EmailreturnResource.GetEmailreturnResponse(responseBuilder.build());
        }

    }

    public class PostEmailreturnResponse
        extends org.folio.rest.jaxrs.resource.support.ResponseWrapper
    {


        private PostEmailreturnResponse(Response delegate) {
            super(delegate);
        }

        /**
         * Returns a newly created item, with server-controlled fields like 'id' populated e.g. {
         *     "id": "23fdb0bc-ab58-442a-b326-577a96204487",
         *     "itemid": "23fdb0bc-ab58-442a-b326-577a96204487",
         *     "email": "ben@gmail.com",
         *     "itemname": "Asus Tablet",
         *     "pdf": "jfioewjfjeio"
         * }
         * 
         * @param location
         *     URI to the created emailreturn item
         * @param entity
         *     {
         *         "id": "23fdb0bc-ab58-442a-b326-577a96204487",
         *         "itemid": "23fdb0bc-ab58-442a-b326-577a96204487",
         *         "email": "ben@gmail.com",
         *         "itemname": "Asus Tablet",
         *         "pdf": "jfioewjfjeio"
         *     }
         */
        public static EmailreturnResource.PostEmailreturnResponse withJsonCreated(String location, StreamingOutput entity) {
            Response.ResponseBuilder responseBuilder = Response.status(201).header("Content-Type", "application/json").header("Location", location);
            responseBuilder.entity(entity);
            return new EmailreturnResource.PostEmailreturnResponse(responseBuilder.build());
        }

        /**
         * Bad request, e.g. malformed request body or query parameter. Details of the error (e.g. name of the parameter or line/character number with malformed data) provided in the response. e.g. "unable to add emailreturn -- malformed JSON at 13:3"
         * 
         * 
         * @param entity
         *     "unable to add emailreturn -- malformed JSON at 13:3"
         *     
         */
        public static EmailreturnResource.PostEmailreturnResponse withPlainBadRequest(String entity) {
            Response.ResponseBuilder responseBuilder = Response.status(400).header("Content-Type", "text/plain");
            responseBuilder.entity(entity);
            return new EmailreturnResource.PostEmailreturnResponse(responseBuilder.build());
        }

        /**
         * Not authorized to perform requested action e.g. unable to create emailreturn -- unauthorized
         * 
         * @param entity
         *     unable to create emailreturn -- unauthorized
         */
        public static EmailreturnResource.PostEmailreturnResponse withPlainUnauthorized(String entity) {
            Response.ResponseBuilder responseBuilder = Response.status(401).header("Content-Type", "text/plain");
            responseBuilder.entity(entity);
            return new EmailreturnResource.PostEmailreturnResponse(responseBuilder.build());
        }

        /**
         * Internal server error, e.g. due to misconfiguration e.g. Internal server error, contact administrator
         * 
         * @param entity
         *     Internal server error, contact administrator
         */
        public static EmailreturnResource.PostEmailreturnResponse withPlainInternalServerError(String entity) {
            Response.ResponseBuilder responseBuilder = Response.status(500).header("Content-Type", "text/plain");
            responseBuilder.entity(entity);
            return new EmailreturnResource.PostEmailreturnResponse(responseBuilder.build());
        }

    }

}
