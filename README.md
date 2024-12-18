# 📚 Boekenclub Project

Welkom bij het **Boekenclub Project**, een innovatieve oplossing voor boekenliefhebbers om samen te komen, te discussiëren over boeken en recensies te delen. Dit platform is ontworpen met een moderne microservices-architectuur, waardoor schaalbaarheid en flexibiliteit centraal staan. Of je nu lid bent van een boekenclub of gewoon een passie hebt voor lezen, dit project brengt een hele community samen rond de liefde voor boeken.

---

## 🚀 Functionaliteiten

- **Ledenbeheer**  
  Houd informatie over clubleden up-to-date.

- **Besprekingen**  
  Organiseer en beheer bijeenkomsten om boeken te bespreken.

- **Recensies**  
  Deel meningen en recensies over gelezen boeken.

- **Boekenbeheer**  
  Creëer een overzicht van alle boeken die de club leest.

---

## ⚙️ Microservice-Architectuur

Het project bestaat uit vier kernservices:

1. **Lid Service**: Beheert alle gegevens van boekenclublidmaatschappen.
2. **Bespreking Service**: Handelt het plannen en beheren van boekenbesprekingen af.
3. **Recensie Service**: Zorgt voor het aanmaken, bekijken en beheren van boekrecensies.
4. **Boek Service**: Beheert de metadata en informatie over de boeken van de club.

Elke service functioneert onafhankelijk, maar ze werken samen via duidelijke en goed gedefinieerde API’s om een soepele gebruikerservaring te bieden.

---

## 🔧 Technologieën

**Backend**: Java Spring Boot  
**Databases**: MySQL (voor gestructureerde gegevens) en MongoDB (voor meer flexibele gegevens zoals recensies)  
**Architectuur**: Microservices  
**Testing & Tools**: Maven, Lombok, Postman (voor API-tests)  
**Containerisatie**: Docker & Kubernetes voor schaalbare en robuuste implementatie

---

## 🖋️ API Endpoints

De volgende endpoints maken interactie met de verschillende services mogelijk:

### Lid Service
- **GET /leden**: Haal een overzicht op van alle leden.
- **POST /leden**: Voeg een nieuw lid toe.
- **PUT /leden/{id}**: Werk lidinformatie bij.
- **DELETE /leden/{id}**: Verwijder een lid.

### Bespreking Service
- **GET /besprekingen**: Bekijk een lijst van alle besprekingen.
- **POST /besprekingen**: Plan een nieuwe bespreking.
- **PUT /besprekingen/{id}**: Werk de details van een bespreking bij.
- **DELETE /besprekingen/{id}**: Annuleer een bespreking.

### Recensie Service
- **GET /recensies**: Bekijk alle recensies.
- **POST /recensies**: Schrijf een nieuwe recensie.
- **PUT /recensies/{id}**: Pas een bestaande recensie aan.
- **DELETE /recensies/{id}**: Verwijder een recensie.

### Boek Service
- **GET /boeken**: Bekijk de catalogus van boeken.
- **POST /boeken**: Voeg een nieuw boek toe.
- **PUT /boeken/{id}**: Werk boekinformatie bij.
- **DELETE /boeken/{id}**: Verwijder een boek uit de catalogus.

---

## 🔄 Samenwerking tussen Services

De microservices communiceren via RESTful API’s. Bijvoorbeeld:
- **Recensie Service** gebruikt de **Boek Service** om boekinformatie op te halen voor recensies.
- **Bespreking Service** raadpleegt de **Lid Service** om deelnemers aan een bespreking te beheren.

---

## 🌐 Deployment Architectuur

1. **Containerisatie**: Elke service wordt uitgevoerd in een aparte Docker-container.
2. **Orchestratie**: Kubernetes .yml-bestanden zijn aanwezig voor een geautomatiseerde en schaalbare uitrol (gedeeltelijk werkend).
3. **Continuous Integration & Delivery**: Geconfigureerd met GitHub Actions om het bouwen en testen van Docker-containers te automatiseren.

---

## 🔍 Testen

- **Unit Tests**: Alle services bevatten uitgebreide unit tests.
- **Postman**: API-endpoints zijn grondig getest met behulp van Postman.
- **Automatisering**: Testpijplijnen in GitHub Actions waarborgen codekwaliteit en functionaliteit.

---

## 📈 Conclusie

Dit Boekenclub Project biedt een complete oplossing voor het beheren van een boekenclub, met aandacht voor schaalbaarheid en gebruiksvriendelijkheid. Dankzij de microservices-architectuur kunnen afzonderlijke functionaliteiten eenvoudig worden uitgebreid of aangepast. Of het nu gaat om het delen van recensies, het organiseren van besprekingen, of simpelweg het beheren van leden en boeken – dit platform legt de basis voor een bruisende boekencommunity.

