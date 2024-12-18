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
  ![GET /api/lid](images/getLeden.png)  

- **POST /api/lid** - Voeg een nieuw lid toe  
  ![POST /api/lid](images/postLid.png)  

- **PUT /api/lid/{id}** - Werk informatie van een lid bij  
  ![PUT /api/lid/{id}](images/putLid.png)  

- **DELETE /api/lid/{id}** - Verwijder een lid  
  ![DELETE /api/lid/{id}](images/deleteLid.png)  

---

### 2. **Bespreking Service**
- **GET /api/bespreking** - Haal alle besprekingen op  
  ![GET /api/bespreking](images/getBespreking.png)  

- **POST /api/bespreking** - Maak een nieuwe bespreking  
  ![POST /api/bespreking](images/postBespreking.png)  

- **PUT /api/bespreking/{id}** - Update een bespreking  
  ![PUT /api/bespreking/{id}](images/putBespreking.png)  

- **DELETE /api/bespreking/{id}** - Verwijder een bespreking  
  ![DELETE /api/bespreking/{id}](images/deleteBespreking.png)  

---

### 3. **Recensie Service**
- **GET /api/recensies** - Haal alle recensies op  
  ![GET /api/recensie](images/getRecensie.png)

- **GET /api/recensies/{lidID}** - haal recensie op via lidID
  ![GET /api/recensie](images/getByLidIdRecensie.png)

- **POST /api/recensies** - Voeg een nieuwe recensie toe  
  ![POST /api/recensie](images/postRecensies.png)  

- **PUT /api/recensies/{id}** - Update een recensie  
  ![PUT /api/recensie/{id}](images/putRecensie.png)  

- **DELETE /api/recensies/{id}** - Verwijder een recensie  
  ![DELETE /api/recensie/{id}](images/deleteRecensie.png)  

---

### 4. **Boek Service**
- **GET /api/boek** - Haal alle boeken op  
  ![GET /api/boek](images/getBoek.png)  

- **POST /api/boek** - Voeg een nieuw boek toe  
  ![POST /api/boek](images/postBoek.png)  

- **PUT /api/boek/{id}** - Update een boek  
  ![PUT /api/boek/{id}](images/putBoek.png)  

- **DELETE /api/boek/{id}** - Verwijder een boek  
  ![DELETE /api/boek/{id}](images/deleteBoek.png)  

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

