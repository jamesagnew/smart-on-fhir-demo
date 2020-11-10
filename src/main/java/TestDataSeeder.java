import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.client.api.IGenericClient;
import ca.uhn.fhir.rest.client.interceptor.LoggingInterceptor;
import org.hl7.fhir.r4.model.DateTimeType;
import org.hl7.fhir.r4.model.Enumerations;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.SimpleQuantity;

public class TestDataSeeder {


    public static void main(String[] args) {

        FhirContext ctx = FhirContext.forR4();
        IGenericClient client = ctx.newRestfulGenericClient("https://smartdemo.smilecdr.com:8000");
        client.registerInterceptor(new LoggingInterceptor(true));

        Patient patient = new Patient();
        patient.setId("james-agnew");
        patient.addName().setFamily("Agnew").addGiven("James").addGiven("E");
        patient.getBirthDateElement().setValueAsString("2020-01-01");
        patient.setGender(Enumerations.AdministrativeGender.MALE);
        client.update().resource(patient).execute();

        // Week 1
        Observation weight1 = new Observation();
        weight1.setId("james-agnew-weight-1");
        weight1.getCode().addCoding().setSystem("http://loinc.org").setCode("3141-9").setDisplay("Body weight Measured");
        weight1.getSubject().setReference("Patient/james-agnew");
        weight1.setEffective(new DateTimeType("2020-01-05T00:00:00Z"));
        weight1.setValue(new SimpleQuantity().setSystem("http://unitsofmeasure.org").setCode("kg").setUnit("kg").setValue(3.0));
        client.update().resource(weight1).execute();

        Observation height1 = new Observation();
        height1.setId("james-agnew-height-1");
        height1.getCode().addCoding().setSystem("http://loinc.org").setCode("8302-2").setDisplay("Body Height");
        height1.getSubject().setReference("Patient/james-agnew");
        height1.setEffective(new DateTimeType("2020-01-05T00:00:00Z"));
        height1.setValue(new SimpleQuantity().setSystem("http://unitsofmeasure.org").setCode("cm").setUnit("cm").setValue(48.0));
        client.update().resource(height1).execute();

        // Week 3
        Observation weight2 = new Observation();
        weight2.setId("james-agnew-weight-2");
        weight2.getCode().addCoding().setSystem("http://loinc.org").setCode("3141-9").setDisplay("Body weight Measured");
        weight2.getSubject().setReference("Patient/james-agnew");
        weight2.setEffective(new DateTimeType("2020-01-25T00:00:00Z"));
        weight2.setValue(new SimpleQuantity().setSystem("http://unitsofmeasure.org").setCode("kg").setUnit("kg").setValue(5.0));
        client.update().resource(weight2).execute();

        Observation height2 = new Observation();
        height2.setId("james-agnew-height-2");
        height2.getCode().addCoding().setSystem("http://loinc.org").setCode("8302-2").setDisplay("Body Height");
        height2.getSubject().setReference("Patient/james-agnew");
        height2.setEffective(new DateTimeType("2020-01-25T00:00:00Z"));
        height2.setValue(new SimpleQuantity().setSystem("http://unitsofmeasure.org").setCode("cm").setUnit("cm").setValue(53.0));
        client.update().resource(height2).execute();

        // Week 3
        Observation weight3 = new Observation();
        weight3.setId("james-agnew-weight-3");
        weight3.getCode().addCoding().setSystem("http://loinc.org").setCode("3141-9").setDisplay("Body weight Measured");
        weight3.getSubject().setReference("Patient/james-agnew");
        weight3.setEffective(new DateTimeType("2020-02-13T00:00:00Z"));
        weight3.setValue(new SimpleQuantity().setSystem("http://unitsofmeasure.org").setCode("kg").setUnit("kg").setValue(6.1));
        client.update().resource(weight3).execute();

        Observation height3 = new Observation();
        height3.setId("james-agnew-height-3");
        height3.getCode().addCoding().setSystem("http://loinc.org").setCode("8302-2").setDisplay("Body Height");
        height3.getSubject().setReference("Patient/james-agnew");
        height3.setEffective(new DateTimeType("2020-02-13T00:00:00Z"));
        height3.setValue(new SimpleQuantity().setSystem("http://unitsofmeasure.org").setCode("cm").setUnit("cm").setValue(56.0));
        client.update().resource(height3).execute();

    }

}
