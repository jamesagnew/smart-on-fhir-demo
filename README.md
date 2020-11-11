# SMART on FHIR Demo

For this demonstration we will be using the **SMART Growth Chart** application. This app is open source. You can browse its source here: https://github.com/smart-on-fhir/growth-chart-app

# Part 1 - A Simple Launch

Try launching the following URL to see a demo SMART on FHIR Application using a pre-existing dataset. 

https://smartdemo.smilecdr.com:9201/resources/cdr-smart-apps-growth-chart-app/launch.html?iss=https://smartdemo.smilecdr.com:8000&launch=wd9833&patientId=james-agnew

Login Credentials (enter these when prompted to log in):
  * Username: `admin`
  * Password: `helloworld`
  
Client Credentials (not needed for this demo but supplied just in case):
  * Client ID: `growth_chart`
  * Client Secret: `helloclient`
  
# Part 2 - Create Your Own Data

For the following exercise, you will now create your own data and launch the SMART Growth Chart app to display it.

Note the following: Resource IDs below will contain a string `family-given`. Replace this with your own name, or any other words you invent, so that your test resources don't conflict with someone else's.

**Step 1**: Upload the following Patient resource by issuing an HTTP **PUT** to the following URL: https://smartdemo.smilecdr.com:8000/Patient/family-given

```json
{
  "resourceType": "Patient",
  "id": "family-given",
  "meta": {
    "versionId": "1",
    "lastUpdated": "2020-11-10T20:24:48.194+00:00"
  },
  "name": [ {
    "family": "Family",
    "given": [ "Given" ]
  } ],
  "gender": "male",
  "birthDate": "2020-01-01"
}
```

**Step 2**: Upload a weight measurement by issuing an HTTP **PUT** to the following URL: https://smartdemo.smilecdr.com:8000/Observation/family-given-weight-1 

```json
{
  "resourceType": "Observation",
  "id": "family-given-weight-1",
  "code": {
    "coding": [ {
      "system": "http://loinc.org",
      "code": "3141-9",
      "display": "Body weight Measured"
    } ]
  },
  "subject": {
    "reference": "Patient/family-given"
  },
  "effectiveDateTime": "2020-01-05T00:00:00Z",
  "valueQuantity": {
    "value": 3.0,
    "unit": "kg",
    "system": "http://unitsofmeasure.org",
    "code": "kg"
  }
}
```

**Step 3**: Upload a height measurement by issuing an HTTP **PUT** to the following URL: https://smartdemo.smilecdr.com:8000/Observation/family-given-height-1 

```json
{
  "resourceType": "Observation",
  "id": "family-given-weight-1",
  "code": {
    "coding": [ {
      "system": "http://loinc.org",
      "code": "8302-2",
      "display": "Body Height"
    } ]
  },
  "subject": {
    "reference": "Patient/family-given"
  },
  "effectiveDateTime": "2020-01-05T00:00:00Z",
  "valueQuantity": {
    "value": 48.0,
    "unit": "cm",
    "system": "http://unitsofmeasure.org",
    "code": "cm"
  }
}
```

**Step 4**: Try it out!

Launch the following URL, but replace the Patient ID at the end of the URL with your own URL:

https://smartdemo.smilecdr.com:9201/resources/cdr-smart-apps-growth-chart-app/launch.html?iss=https://smartdemo.smilecdr.com:8000&launch=wd9833&patientId=family-given

**Step 5**: Try adding more observations. Repeat! 
