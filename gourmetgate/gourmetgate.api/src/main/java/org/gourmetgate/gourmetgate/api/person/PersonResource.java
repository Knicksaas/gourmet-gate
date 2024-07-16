package org.gourmetgate.gourmetgate.api.person;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.rest.IRestResource;

import org.gourmetgate.gourmetgate.core.person.PersonService;
import org.gourmetgate.gourmetgate.data.person.PersonDo;
import org.gourmetgate.gourmetgate.data.person.PersonResponse;
import org.gourmetgate.gourmetgate.data.person.PersonRestrictionDo;

@Path("persons")
public class PersonResource implements IRestResource {

  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public PersonResponse getById(@PathParam("id") String id) {
    return BEANS.get(PersonService.class)
        .getById(id)
        .map(item -> BEANS.get(PersonResponse.class).withItem(item))
        .orElseGet(PersonResponse::new);
  }

  @POST
  @Path("list")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public PersonResponse list(PersonRestrictionDo restrictions) {
    return BEANS.get(PersonResponse.class)
        .withItems(BEANS.get(PersonService.class).list(restrictions));
  }

  @PUT
  @Path("/{id}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public PersonResponse store(@PathParam("id") String id, PersonDo person) {
    return BEANS.get(PersonResponse.class)
        .withItem(BEANS.get(PersonService.class).store(id, person));
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public PersonResponse create(PersonDo person) {
    return BEANS.get(PersonResponse.class)
        .withItem(BEANS.get(PersonService.class).create(person));
  }

  @DELETE
  @Path("/{id}")
  @Consumes(MediaType.APPLICATION_JSON)
  public void remove(@PathParam("id") String id) {
    BEANS.get(PersonService.class).remove(id);
  }
}
