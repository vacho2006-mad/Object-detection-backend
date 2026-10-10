# VISION AI — Backend

Java 21 + Spring Boot + Spring Data JPA REST API. The API stores detection history in MySQL.

## API endpoints

- `GET /detection/all` — list saved detections
- `POST /detection/add` — save a detection JSON body such as `{"objectName":"bottle","confidence":0.91,"detectedTime":"10:30:00 AM"}`
- `DELETE /detection/clear` — clear detection history

## Run locally (Windows PowerShell)

Prerequisites: Java 21 and MySQL.

1. Create the database in MySQL:

```sql
CREATE DATABASE object_detection;
```

2. Check `src/main/resources/application.properties`. Defaults are `localhost:3306/object_detection`, username `root`, password `1234`. Change these to match your local MySQL setup. Do not use local defaults in production.
3. Start the backend from this folder:

```powershell
.\mvnw.cmd spring-boot:run
```

API base URL: `http://localhost:9090`.

## Deploy backend to Render with Docker

1. Push this `backend` folder to its own GitHub repository (recommended), or deploy the combined repository and set the Docker context/root directory to `backend`.
2. In Render, create **New + → Web Service**, connect the backend repository, choose **Docker**, and keep the Dockerfile path as `./Dockerfile`.
3. Add environment variables:
   - `DB_URL`: complete JDBC URL for your externally hosted MySQL database, e.g. `jdbc:mysql://HOST:3306/DATABASE?useSSL=true&serverTimezone=UTC`
   - `DB_USERNAME`: database username
   - `DB_PASSWORD`: database password
4. Deploy. Render's free web service is not a database; use an external MySQL provider with network access enabled for Render.
5. Copy the deployed service URL into the frontend's `VITE_API_URL` setting.

## Security / demo notes

CORS is open for this student demo API so a separately hosted frontend can call it. For production, restrict allowed origins to your actual frontend domain. Never commit database credentials.
