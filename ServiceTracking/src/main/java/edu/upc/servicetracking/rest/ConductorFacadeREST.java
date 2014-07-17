/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upc.servicetracking.rest;

import edu.upc.servicetracking.entities.Conductor;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.json.stream.JsonParserFactory;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import org.eclipse.persistence.internal.oxm.record.json.JSONReader;

/**
 *
 * @author holivares
 */
@Stateless
@Path("conductor")
public class ConductorFacadeREST extends AbstractFacade<Conductor> {
    @PersistenceContext(unitName = "edu.upc_ServiceTracking_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    public ConductorFacadeREST() {
        super(Conductor.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Conductor entity) {
        super.create(entity);
    }
    
    @POST
    @Path("/auth")
    @Produces({"application/xml", "application/json"})
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void auth(@FormParam("data") String data,
            @Context HttpServletResponse servletResponse,
            @Context HttpServletRequestWrapper request) {
        
        JsonReader jsonReader;
        try {
            jsonReader = Json.createReader(request.getReader());
            JsonObject jo = jsonReader.readObject();
            servletResponse.getWriter().print(jo.getJsonString("data"));
            jsonReader.close();
        } catch (IOException ex) {
            Logger.getLogger(ConductorFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            
            servletResponse.flushBuffer();
        } catch (IOException ex) {
            Logger.getLogger(ConductorFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Conductor entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Conductor find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Conductor> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Conductor> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
