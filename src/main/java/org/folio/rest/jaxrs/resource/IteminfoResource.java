
package org.folio.rest.jaxrs.resource;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.ws.rs.Consumes;
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
import org.folio.rest.jaxrs.model.Item;
import org.folio.rest.jaxrs.model.ItemInfoCollection;


/**
 * Collection of iteminfo items.
 * 
 */
@Path("iteminfo")
public interface IteminfoResource {


    /**
     * Returns a list of items.
     * 
     * @param offset
     *     Skip over a number of elements by specifying an offset value for the query e.g. 0
     * @param query
     *     JSON array [{"field1","value1","operator1"},{"field2","value2","operator2"},...,{"fieldN","valueN","operatorN"}] with valid searchable fields
     *      e.g. title=aaa
     *     
     * @param limit
     *     Limit the number of elements returned in the response e.g. 10
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
    void getIteminfo(
        @QueryParam("query")
        String query,
        @QueryParam("offset")
        @DefaultValue("0")
        @Min(0L)
        @Max(1000L)
        int offset,
        @QueryParam("limit")
        @DefaultValue("10")
        @Min(1L)
        @Max(100L)
        int limit,
        @QueryParam("lang")
        @DefaultValue("en")
        @Pattern(regexp = "[a-zA-Z]{2}")
        String lang, java.util.Map<String, String>okapiHeaders, io.vertx.core.Handler<io.vertx.core.AsyncResult<Response>>asyncResultHandler, Context vertxContext)
        throws Exception
    ;

    /**
     * Returns a list of items.
     * 
     * @param offset
     *     Skip over a number of elements by specifying an offset value for the query e.g. 0
     * @param query
     *     JSON array [{"field1","value1","operator1"},{"field2","value2","operator2"},...,{"fieldN","valueN","operatorN"}] with valid searchable fields
     *      e.g. title=aaa
     *     
     * @param limit
     *     Limit the number of elements returned in the response e.g. 10
     * @param vertxContext
     *      The Vertx Context Object <code>io.vertx.core.Context</code> 
     * @param asyncResultHandler
     *     A <code>Handler<AsyncResult<Response>>></code> handler {@link io.vertx.core.Handler} which must be called as follows - Note the 'GetPatronsResponse' should be replaced with '[nameOfYourFunction]Response': (example only) <code>asyncResultHandler.handle(io.vertx.core.Future.succeededFuture(GetPatronsResponse.withJsonOK( new ObjectMapper().readValue(reply.result().body().toString(), Patron.class))));</code> in the final callback (most internal callback) of the function.
     * @param lang
     *     Requested language. Optional. [lang=en]
     *     
     * @param entity
     *      e.g. {
     *     "id": "0",
     *     "itemid": "23fdb0bc-ab58-442a-b326-577a96204487",
     *     "copy_number": "1",
     *     "total_pieces": "1",
     *     "price": "$70.00",
     *     "piece_list": [
     *     "Mini DisplayPort to VGA Adapter."
     *     ]
     *     }
     */
    @POST
    @Consumes("application/json")
    @Produces({
        "application/json",
        "text/plain"
    })
    @Validate
    void postIteminfo(
        @QueryParam("query")
        String query,
        @QueryParam("offset")
        @DefaultValue("0")
        @Min(0L)
        @Max(1000L)
        int offset,
        @QueryParam("limit")
        @DefaultValue("10")
        @Min(1L)
        @Max(100L)
        int limit,
        @QueryParam("lang")
        @DefaultValue("en")
        @Pattern(regexp = "[a-zA-Z]{2}")
        String lang, Item entity, java.util.Map<String, String>okapiHeaders, io.vertx.core.Handler<io.vertx.core.AsyncResult<Response>>asyncResultHandler, Context vertxContext)
        throws Exception
    ;

    public class GetIteminfoResponse
        extends org.folio.rest.jaxrs.resource.support.ResponseWrapper
    {


        private GetIteminfoResponse(Response delegate) {
            super(delegate);
        }

        /**
         * Returns a list of iteminfo items e.g. {
         *   "iteminfo": [
         *     {
         * 			"id": "0",
         * 			"itemid": "23fdb0bc-ab58-442a-b326-577a96204487",
         * 			"copy_number": "1",
         * 			"total_pieces": "1",
         * 			"price": "$70.00",
         * 			"piece_list": [
         * 			"Mini DisplayPort to VGA Adapter."
         * 			]
         * 		},
         * 		{
         * 		"id": "1",
         * 		"itemid": "81335b5b-84f2-4e1a-b154-b010978cd09b",
         * 		"copy_number": "1",
         * 		"total_pieces": "8",
         * 		"price": "$500.00",
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
         * @param entity
         *     {
         *       "iteminfo": [
         *         {
         *     			"id": "0",
         *     			"itemid": "23fdb0bc-ab58-442a-b326-577a96204487",
         *     			"copy_number": "1",
         *     			"total_pieces": "1",
         *     			"price": "$70.00",
         *     			"piece_list": [
         *     			"Mini DisplayPort to VGA Adapter."
         *     			]
         *     		},
         *     		{
         *     		"id": "1",
         *     		"itemid": "81335b5b-84f2-4e1a-b154-b010978cd09b",
         *     		"copy_number": "1",
         *     		"total_pieces": "8",
         *     		"price": "$500.00",
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
         */
        public static IteminfoResource.GetIteminfoResponse withJsonOK(ItemInfoCollection entity) {
            Response.ResponseBuilder responseBuilder = Response.status(200).header("Content-Type", "application/json");
            responseBuilder.entity(entity);
            return new IteminfoResource.GetIteminfoResponse(responseBuilder.build());
        }

        /**
         * Bad request, e.g. malformed request body or query parameter. Details of the error (e.g. name of the parameter or line/character number with malformed data) provided in the response. e.g. unable to list iteminfo -- malformed parameter 'query', syntax error at column 6
         * 
         * @param entity
         *     unable to list iteminfo -- malformed parameter 'query', syntax error at column 6
         */
        public static IteminfoResource.GetIteminfoResponse withPlainBadRequest(String entity) {
            Response.ResponseBuilder responseBuilder = Response.status(400).header("Content-Type", "text/plain");
            responseBuilder.entity(entity);
            return new IteminfoResource.GetIteminfoResponse(responseBuilder.build());
        }

        /**
         * Not authorized to perform requested action e.g. unable to list iteminfo -- unauthorized
         * 
         * @param entity
         *     unable to list iteminfo -- unauthorized
         */
        public static IteminfoResource.GetIteminfoResponse withPlainUnauthorized(String entity) {
            Response.ResponseBuilder responseBuilder = Response.status(401).header("Content-Type", "text/plain");
            responseBuilder.entity(entity);
            return new IteminfoResource.GetIteminfoResponse(responseBuilder.build());
        }

        /**
         * Internal server error, e.g. due to misconfiguration e.g. internal server error, contact administrator
         * 
         * @param entity
         *     internal server error, contact administrator
         */
        public static IteminfoResource.GetIteminfoResponse withPlainInternalServerError(String entity) {
            Response.ResponseBuilder responseBuilder = Response.status(500).header("Content-Type", "text/plain");
            responseBuilder.entity(entity);
            return new IteminfoResource.GetIteminfoResponse(responseBuilder.build());
        }

    }

    public class PostIteminfoResponse
        extends org.folio.rest.jaxrs.resource.support.ResponseWrapper
    {


        private PostIteminfoResponse(Response delegate) {
            super(delegate);
        }

        /**
         * Returns a newly created item, with server-controlled fields like 'id' populated e.g. {
         * "id": "0",
         * "itemid": "23fdb0bc-ab58-442a-b326-577a96204487",
         * "copy_number": "1",
         * "total_pieces": "1",
         * "price": "$70.00",
         * "piece_list": [
         * "Mini DisplayPort to VGA Adapter."
         * ]
         * }
         * 
         * @param location
         *     URI to the created iteminfo item
         * @param entity
         *     {
         *     "id": "0",
         *     "itemid": "23fdb0bc-ab58-442a-b326-577a96204487",
         *     "copy_number": "1",
         *     "total_pieces": "1",
         *     "price": "$70.00",
         *     "piece_list": [
         *     "Mini DisplayPort to VGA Adapter."
         *     ]
         *     }
         */
        public static IteminfoResource.PostIteminfoResponse withJsonCreated(String location, StreamingOutput entity) {
            Response.ResponseBuilder responseBuilder = Response.status(201).header("Content-Type", "application/json").header("Location", location);
            responseBuilder.entity(entity);
            return new IteminfoResource.PostIteminfoResponse(responseBuilder.build());
        }

        /**
         * Bad request, e.g. malformed request body or query parameter. Details of the error (e.g. name of the parameter or line/character number with malformed data) provided in the response. e.g. "unable to add iteminfo -- malformed JSON at 13:3"
         * 
         * 
         * @param entity
         *     "unable to add iteminfo -- malformed JSON at 13:3"
         *     
         */
        public static IteminfoResource.PostIteminfoResponse withPlainBadRequest(String entity) {
            Response.ResponseBuilder responseBuilder = Response.status(400).header("Content-Type", "text/plain");
            responseBuilder.entity(entity);
            return new IteminfoResource.PostIteminfoResponse(responseBuilder.build());
        }

        /**
         * Not authorized to perform requested action e.g. unable to create iteminfo -- unauthorized
         * 
         * @param entity
         *     unable to create iteminfo -- unauthorized
         */
        public static IteminfoResource.PostIteminfoResponse withPlainUnauthorized(String entity) {
            Response.ResponseBuilder responseBuilder = Response.status(401).header("Content-Type", "text/plain");
            responseBuilder.entity(entity);
            return new IteminfoResource.PostIteminfoResponse(responseBuilder.build());
        }

        /**
         * Internal server error, e.g. due to misconfiguration e.g. Internal server error, contact administrator
         * 
         * @param entity
         *     Internal server error, contact administrator
         */
        public static IteminfoResource.PostIteminfoResponse withPlainInternalServerError(String entity) {
            Response.ResponseBuilder responseBuilder = Response.status(500).header("Content-Type", "text/plain");
            responseBuilder.entity(entity);
            return new IteminfoResource.PostIteminfoResponse(responseBuilder.build());
        }

    }

}
