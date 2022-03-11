package rs.ac.uns.ftn.isa.serializers;

import com.google.gson.*;
import java.lang.reflect.Type;
import rs.ac.uns.ftn.isa.model.Ocena;

public class OcenaSerializer implements JsonSerializer<Ocena> {

	@Override
	public JsonElement serialize(Ocena ocena, Type type, JsonSerializationContext jsc) {
		JsonObject jObj = (JsonObject) new GsonBuilder().create().toJsonTree(ocena);
		if (ocena.getStudent() != null) {
			jObj.remove("student");
			jObj.addProperty("student",
					"http://localhost:8080/api/student/" + ocena.getStudent().getIndeks() + "?format=json2");
		}
		if (ocena.getPredmet() != null) {
			jObj.remove("predmet");
			jObj.addProperty("predmet",
					"http://localhost:8080/api/predmet/" + ocena.getPredmet().getSifra() + "?format=json2");
		}
		return jObj;
	}

}
