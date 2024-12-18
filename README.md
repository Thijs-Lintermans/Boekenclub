# 📚 Boekenclub Project

Welkom bij ons **Boekenclub Project**! Dit project is een platform voor boekenliefhebbers om samen te komen, boeken te bespreken en recensies te delen. Het is opgebouwd uit een moderne microservice-architectuur met vier onafhankelijke services.

---

## 🚀 Functionaliteiten

- **Ledenbeheer**  
  Beheer informatie over de leden van de boekenclub.

- **Besprekingen**  
  Organiseer en bekijk besprekingen waar leden samenkomen om boeken te bespreken.

- **Recensies**  
  Laat leden recensies schrijven en delen over de gelezen boeken.

- **Boekenbeheer**  
  Houd een overzicht van alle boeken die door de boekenclub worden gelezen.

---

## ⚙️ Microservice Architectuur

Het project bestaat uit de volgende services:

1. **Lid Service**  
   Beheert gegevens van de boekenclubleden.

2. **Bespreking Service**  
   Verantwoordelijk voor het plannen en beheren van besprekingen.

3. **Recensie Service**  
   Handelt het schrijven, bekijken en beheren van recensies af.

4. **Boek Service**  
   Beheert de informatie over de boeken in de club.

---

## 🛠️ Technologieën

- **Backend**: Java Spring Boot
- **Database**: MySQL, MongoDB
- **Architectuur**: Microservices
- **Tools**: Maven, Lombok, Postman (voor testen van APIs)
- **Deployment**: Docker, Kubernetes
- **CI/CD**: GitHub Actions

---

## 🌐 Deployment Architectuur

Onderstaande afbeelding geeft de deployment architectuur van het Boekenclub Project weer. Elke service wordt als container gedraaid en beheerd door Kubernetes, waarbij zowel MongoDB als MySQL gebruikt worden voor datastorage.

![Deployment Architectuur](images/Untitled%20Diagram.drawio.png)

### Toelichting:
- **API Gateway**: Beheert het inkomende verkeer en routeert verzoeken naar de juiste microservices.
- **Services**: Elke microservice is onafhankelijk en beheert specifieke functionaliteiten zoals lidbeheer, boekbeheer, recensies en besprekingen.
- **Databases**: 
   - MongoDB wordt gebruikt voor ongestructureerde data (Leden en Boeken).
   - MySQL wordt gebruikt voor gestructureerde data (Besprekingen en Recensies).

---

## 🔗 API Endpoints

Hieronder vind je de belangrijkste API-endpoints per service. Screenshots van Postman of de testresultaten zijn toegevoegd.

### 1. **Lid Service**
- **GET /api/lid** - Haal alle leden op  
  ![GET /api/lid](images/get_api_lid.png)  

- **POST /api/lid** - Voeg een nieuw lid toe  
  ![POST /api/lid](images/post_api_lid.png)  

- **PUT /api/lid/{id}** - Werk informatie van een lid bij  
  ![PUT /api/lid/{id}](images/put_api_lid.png)  

- **DELETE /api/lid/{id}** - Verwijder een lid  
  ![DELETE /api/lid/{id}](images/delete_api_lid.png)  

---

### 2. **Bespreking Service**
- **GET /api/bespreking** - Haal alle besprekingen op  
  ![GET /api/bespreking](images/get_api_bespreking.png)  

- **POST /api/bespreking** - Maak een nieuwe bespreking  
  ![POST /api/bespreking](images/post_api_bespreking.png)  

- **PUT /api/bespreking/{id}** - Update een bespreking  
  ![PUT /api/bespreking/{id}](images/put_api_bespreking.png)  

- **DELETE /api/bespreking/{id}** - Verwijder een bespreking  
  ![DELETE /api/bespreking/{id}](images/delete_api_bespreking.png)  

---

### 3. **Recensie Service**
- **GET /api/recensies** - Haal alle recensies op  
  ![GET /api/recensie](images/get_api_recensie.png)

-**GET /api/recensies/{lidID}** - haal recensie op via lidID
  ![GET /api/recensie](images/get_api_recensie.png)

- **POST /api/recensies** - Voeg een nieuwe recensie toe  
  ![POST /api/recensie](images/post_api_recensie.png)  

- **PUT /api/recensies/{id}** - Update een recensie  
  ![PUT /api/recensie/{id}](images/put_api_recensie.png)  

- **DELETE /api/recensies/{id}** - Verwijder een recensie  
  ![DELETE /api/recensie/{id}](images/delete_api_recensie.png)  

---

### 4. **Boek Service**
- **GET /api/boek** - Haal alle boeken op  
  ![GET /api/boek](images/get_api_boek.png)  

- **POST /api/boek** - Voeg een nieuw boek toe  
  ![POST /api/boek](images/post_api_boek.png)  

- **PUT /api/boek/{id}** - Update een boek  
  ![PUT /api/boek/{id}](images/put_api_boek.png)  

- **DELETE /api/boek/{id}** - Verwijder een boek  
  ![DELETE /api/boek/{id}](images/delete_api_boek.png)  

---

## 🧪 **Testing**

- **Unit Tests**: Elke service bevat unit tests om de functionaliteit van endpoints te verifiëren.
- **Postman**: Alle endpoints zijn getest met Postman. Screenshots zijn hierboven toegevoegd.

---

## 📖 Conclusie

Dit project biedt een schaalbare en robuuste oplossing voor een boekenclubplatform door het gebruik van **microservices**, **containerisatie** (Docker, Kubernetes), en moderne ontwikkeltools. Het platform is eenvoudig uitbreidbaar en maakt een duidelijke scheiding tussen services mogelijk.

---

### 💻 **Screenshots en Demo**
- Voeg hier nog screenshots of een demo-video toe indien beschikbaar.

---

