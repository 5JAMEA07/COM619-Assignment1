# KRYPTONITE
## Team Introduction

Welcome to the documentation of our project. This project is a collaborative effort brought to life by a dedicated team of four, each contributing unique skills and expertise. Our application is hosted at [https://kryptonite.uksouth.cloudapp.azure.com/](https://kryptonite.uksouth.cloudapp.azure.com/) , showcasing the culmination of our hard work and dedication. A YouTube video of our project is hosted at: https://youtu.be/nFEl96n28KM


This project was brought to life by a dedicated team of four, each contributing unique skills and expertise. Our team comprises:

### Team Members

1. **Abraham James**  
   **Contributions:** 
   - Developed the entire backend infrastructure.
   - Set up and configured the virtual machine for the project.
   - Implemented SSL for enhanced web server security.
  

2. **Klara Hoffmannova**  
   **Contributions:** 
   - Focused on creating and maintaining the CI/CD pipelines.
   - Managed the deployment of Docker images to Docker Hub.
   - Managed the deployment to Virtual Machine

3. **Nathan Worlock**   
   **Contributions:** 
   - Worked on the frontend development, primarily using React.
   - Collaborated closely with Team Member 4 for frontend tasks.

4. **Jennie Wilson**   
   **Contributions:** 
   - Concentrated on developing the frontend, utilizing React.
   - Paired with Team Member 3 to ensure a cohesive and functional frontend design.
 
## Project Overview

### Technologies Used

In this project, we utilized a range of technologies, each serving a specific purpose to bring our application to life. Below is an overview of the technologies we used and how they contributed to the development of the project.

#### Frontend Application
- **React**: We used React for building our dynamic and responsive frontend. React's component-based architecture allowed us to create an interactive user interface efficiently.

#### Backend Application
- **Java Spring Boot (Java version 11)**: Our backend application was developed using Java Spring Boot, specifically with Java version 11. Spring Boot made it easier to set up and configure our backend, thanks to its vast array of features and simplified deployment process.
- **Maven**: As our package manager for the Java application, Maven was used for managing project dependencies, build processes, and testing. It streamlined our development workflow, ensuring consistency and reliability.

#### Database
- **MySQL**: For database management, we chose MySQL. It offered us the necessary tools for robust data handling, storage, and retrieval, integral for our backend application's functionality.


#### Containerization
- **Docker**: We containerized our application using Docker, which helped in ensuring consistency across different development and deployment environments. Docker simplified our workflow and made our application more scalable and easy to deploy.

#### Continuous Integration and Continuous Deployment (CI/CD)
- **GitHub Actions**: For our CI/CD pipeline, we utilized GitHub Actions. It automated our build, test, and deployment processes, ensuring that our application was always in a deployable state.

#### Virtual Machine and Hosting
- **Microsoft Azure**: We hosted our application on a Virtual Machine provided by Microsoft Azure. Azure offered us a reliable and scalable cloud hosting solution, ensuring our application's availability and performance.

## Folder Structure

Understanding the folder structure is crucial for navigating and understanding the codebase of our project. Here's an overview of the important folders and files:

### Key Directories and Files

- **`src/`**: 
  - **Purpose**: Contains all the source code for the backend application.
  - **Details**: This directory includes all Java Spring Boot code files, configurations, and resources necessary for the backend logic and operations.

- **`view/`**:
  - **Purpose**: Holds all the source code for the frontend application.
  - **Details**: This directory contains React components, stylesheets, and other assets used to build the user interface of the project. The Dockerfile for the frontend is also located here.

- **`docker-compose.yml`**:
  - **Purpose**: Used to define all our Docker containers and their configurations.
  - **Details**: This Docker Compose file orchestrates the setup of multiple containers, setting up the environment for both the frontend and backend applications, including any databases or other dependencies.

- **`Dockerfile`**:
  - **Purpose**: Defines the build structure for the backend Docker image.
  - **Details**: Located at the root, this Dockerfile specifies the steps to create the Docker image of our backend application, including setting up the Java environment and preparing the application for deployment.

- **`view/Dockerfile`**:
  - **Purpose**: Defines the build structure for the frontend Docker image.
  - **Details**: Located within the `view` directory, this Dockerfile outlines the steps to build the frontend Docker image, including installing dependencies and building the React application.

## Getting Started

Follow these steps to download and run the project locally.

### Prerequisites

Before beginning, ensure you have the following installed:
- Java 11
- Maven
- Docker and Docker Compose
- MySQL (optional, only required for running with a local database)

### Step-by-Step Instructions

1. **Clone the Repository**
   Clone the project to your local machine:

      ```
    git clone [Repository URL]
      ```
    

2. **Database Setup** (Optional)
    If you have MySQL installed and wish to use a local database:
    - Start the MySQL service on your machine.
    - Create a database named `devOps`.
    - Run Maven:

      ```
      mvn clean install
      ```
    If you do not have MySQL or prefer not to use a local database, run:
    
      ```
      mvn clean install -DskipTests
      ```
     
3. **Build Docker Images**
    Build the Docker images for the frontend and backend:
     ```
    docker-compose build
    ```

4. **Run the Application**
    Start the application using Docker Compose:
    ```
    docker-compose up
    ```
5. **Access the Application**
    The application will be accessible at [http://localhost:3000](http://localhost:3000).

## Development Workflow and Practices

In this project, our team of four developers adopted a structured and disciplined approach to development, ensuring a seamless and collaborative workflow. Below is an overview of our key practices and strategies:

### Strategic Branch Management

#### Branch Structure
- We initiated our repository with two principal branches: 
  - `development`: This branch functioned as the default destination for all ongoing work, serving as a dynamic and continuously updated base.
  - `production`: Reserved for stable releases, this branch contained our finalized and thoroughly tested code ready for deployment.

#### Issue-Driven Development
- Our development was meticulously organized around GitHub issues. Each task or feature was tracked as a distinct issue, providing clarity and focus.
- Pull requests were systematically linked to these issues, facilitating traceability and accountability in our development process.

### Workflow for New Features and Tasks

#### Preparing the Development Environment
- To ensure synchronization with the latest project state, team members updated their local development branch using:
  ```bash
  git pull origin development
   ```
   For initiating work on new features or tasks, developers branched off from the updated development branch:
   ```bash
   git checkout -b [New Branch Name]
   ```
   When switching from another branch to the development branch, the workflow involved:
   ```bash
   git checkout development
   git pull origin development
   ```
   #### Code Integration and Quality Assurance
    Protected Branches Protocol
    Our development and production branches were fortified with protection rules. Direct commits were restricted, emphasizing the use of pull requests for any code integration.
    This protective measure was pivotal in maintaining the integrity and stability of our primary codebases.
    Peer Review Process
    We enforced a mandatory code review policy for all pull requests. At least one collaborator's approval was required for any merge, ensuring an additional layer of scrutiny and quality control.
    This collaborative review process not only heightened code quality but also fostered knowledge sharing and collective code ownership.
    
# Frontend Development Overview

Our application's frontend, developed using React, showcases a modern, interactive user interface that is both functional and user-friendly. Here's a closer look at its structure and features:

## Key Components

### React Application Setup
- The application is bootstrapped using `ReactDOM.createRoot`, which is the entry point of the React application.
- The `App` component, wrapped in `React.StrictMode`, serves as the root component.

### Main Application Component (`App.jsx`)
- Implements React Router for navigation between different views.
- Manages the application state using React hooks like `useState`.
- Handles user interactions for logging in, signing up, and submitting map points.
- Conditionally renders components based on the application state, such as login and signup forms.

### Authentication and Authorization (`useAuth`)
- Custom hook `useAuth` manages authentication state.
- Retrieves user token and user data from session storage.
- Determines whether a user is logged in for conditional rendering and access control.

### User Interaction Components
- `LoginPage` and `SignUpPage` handle user login and signup processes, respectively.
- `MapPointForm` allows authenticated users to submit new map points.
- `MapView` integrates with `react-leaflet` for displaying interactive maps.

### Navigation and Layout
- `TopNavbarView` provides a navigation bar with login, signup, and user information.
- `SidebarView` offers additional navigation links and access to administrative features (conditional on user role).

### Data Fetching and API Integration
- Axios is used for HTTP requests to interact with the backend API.
- Components like `UsersList` fetch data from the backend and render it in the UI.

### Styling and Layout
- The application uses Bootstrap for styling and layout, ensuring a responsive and modern design.
- Custom CSS files are utilized for additional styling needs.

## Interesting Features

### Dynamic Map Interaction
- The integration of `react-leaflet` for map functionality allows users to interact with geographical data dynamically.
- Users can click on the map to set new map points, enhancing user engagement.

### Role-Based Access Control
- The frontend intelligently handles different user roles, displaying administrative options only to users with the 'ADMINISTRATOR' role.

### Seamless User Experience
- The application's design ensures a smooth and intuitive user experience, with features like overlays for login and signup forms.
- Reactive updates to the UI based on user actions and authentication status provide a seamless flow.

### Secure and Responsive Design
- The use of session storage for authentication tokens and user data contributes to a secure user experience.
- The responsive design, powered by Bootstrap, ensures the application is accessible across various devices and screen sizes.

---

Overall, the frontend of our application is a testament to modern web development practices, offering a rich user experience, interactive features, and a secure, responsive interface.


# Backend Development Overview

The backend of our application is structured into several controllers, each responsible for handling specific types of requests and facilitating various operations. Below is a detailed overview of these controllers:

## MapPointController

### Overview
- **Purpose**: Manages operations related to geographic points or map points.
- **Functionalities**:
  - **Uploading Locations**: Allows users to upload geographic locations without associated images. This requires user authentication.
  - **Updating Map Points with Images**: Enables users to update existing map points with new images, again requiring user authentication.
  - **Retrieving User-Specific Map Points**: Fetches all map points associated with a specific user, controlled through user authentication.

## UserController

### Overview
- **Purpose**: Handles user-related operations like authentication, registration, and user data retrieval.
- **Functionalities**:
  - **User Authentication**: Manages user logins, providing a response token upon successful authentication.
  - **User Registration**: Registers new users into the system with provided sign-up details.
  - **Retrieving All Users**: Fetches a list of all users, restricted to administrators.

The backend of our application uses several model classes, each serving a specific purpose in representing and handling data. Below are the details of these classes:

## LocationUploadRequest

### Purpose
- Represents a request to upload a geographic location.

### Features
- Contains latitude, longitude, username, name, and description.
- Essential for operations where users upload location details.

## LoginRequest

### Purpose
- Models a user's login request.

### Features
- Holds the username and password.
- Used in the authentication process to verify user credentials.

## LoginResponse

### Purpose
- Represents the response for a successful user login.

### Features
- Contains an authentication token and user details.
- Provides necessary data following a successful login.

## SignUpRequest

### Purpose
- Represents a request for signing up a new user.

### Features
- Includes username and password for new user registration.
- Employed in creating new user accounts.

## MapPoint

### Purpose
- Entity representing a geographical point on a map.

### Features
- Includes name, description, coordinates, username, and optional photo URL.
- Central to storing and retrieving geographical data.

## Address (Embedded in User)

### Purpose
- Represents a user's address.

### Features
- Detailed address information including house number, lines, city, and contact numbers.
- Embedded in the `User` entity for comprehensive address details.

## User

### Purpose
- Entity representing a user in the system.

### Features
- Personal information, username, hashed password, address, role, and account status.
- Key to user data management, authentication, and authorization.

## UserRole (Enum)

### Purpose
- Enumerates different user roles.

### Features
- Defines roles like `CUSTOMER` and `ADMINISTRATOR`.
- Distinguishes between access levels and privileges within the application.


Our application's backend is supported by several services, each handling specific functionalities essential for the application's operations.

## FileStorageService

### Purpose
- Manages file storage operations, particularly for saving files to a specified directory.

### Functionalities
- **File Saving**: Responsible for storing files in a pre-defined location while ensuring file integrity and handling exceptions.
- **Environment Configuration**: Determines the storage location based on the environment settings.

## MapPointService

### Purpose
- Handles operations related to geographic points, such as saving and updating map points.

### Functionalities
- **Save Location**: Saves a new location with details like latitude, longitude, username, name, and description. Validates the existence of the associated user.
- **Update Map Point with Image**: Updates an existing map point with a provided image URL. Ensures the existence of the map point before updating.
- **Retrieve User Map Points**: Fetches all map points associated with a specific user, verifying user existence.

## UserService

### Purpose
- Manages user-related operations including authentication, registration, and role verification.

### Functionalities
- **User Authentication**: Authenticates users based on login requests and generates JWT tokens for validated users.
- **User Registration**: Registers new users in the system, ensuring no duplicate usernames.
- **Authorization Status Check**: Validates JWT tokens from the authorization header to verify user authentication status.
- **Admin Role Verification**: Checks if a given user has administrator privileges.
- **Retrieve All Users**: Provides a list of all users in the system.

The backend of our application relies on repository classes to interact with the database. These classes facilitate data access and manipulation for specific entities.

## MapPointRepository

### Purpose
- Manages data access and operations for `MapPoint` entities.

### Functionalities
- **Find All By Username**: Retrieves all `MapPoint` entities associated with a given username. Utilizes a custom query to filter map points based on the username.
- Inherits standard CRUD operations from `JpaRepository`.

## UserRepository

### Purpose
- Handles data access and operations for `User` entities.

### Functionalities
- **Find By Username**: Finds a user by their username. This is particularly useful for authentication and user-specific operations.
- **Find By Names**: Retrieves users based on their first and second names. Supports operations requiring filtering by user names.
- Inherits common CRUD operations from `JpaRepository`.

The backend of our application includes utility classes that provide essential services across the application. The `PasswordUtils` class is pivotal for managing password security.

## PasswordUtils

### Purpose
- Handles password hashing and verification.

### Functionalities
- **Hash Password**: Uses BCrypt to hash passwords. It ensures that passwords are securely stored in a way that protects them from being compromised.
- **Check Password**: Verifies a plain text password against its hashed version. This method is crucial in the authentication process, ensuring that the entered password matches the stored hashed password.

`PasswordUtils` is an integral part of the security measures in our application. It ensures that user passwords are handled in a secure manner, enhancing the overall security of user data.

# Backend Development Summary

The backend of our application is a well-structured and robust system, developed with a focus on efficiency, security, and scalability. Here are the highlights of its development and some interesting features:

## Key Highlights

### RESTful API Design
- The backend is designed around RESTful principles, ensuring clear and standard communication endpoints for the frontend.
- Controllers like `MapPointController` and `UserController` provide a structured approach to handling HTTP requests related to geographic locations and user management.

### Security and Authentication
- Security is a prime focus, especially in managing user authentication and authorization.
- The use of `PasswordUtils` for password hashing and verification adds a layer of security, protecting user credentials.
- JWT tokens, generated and validated in the `UserService`, ensure secure and stateless authentication.

### Data Handling and Persistence
- Models like `User`, `MapPoint`, and various DTOs (`Data Transfer Objects`) define the structure of data handled by the application.
- `JpaRepository` is extensively used in repositories for efficient CRUD operations and custom queries, streamlining interactions with the database.

### Modular and Scalable Architecture
- Services such as `FileStorageService` and `MapPointService` abstract and encapsulate the business logic, promoting a modular architecture.
- This separation of concerns not only makes the codebase more maintainable but also supports scalability.

### Efficient File Management
- `FileStorageService` stands out for its role in managing file storage, demonstrating the application's capability to handle file uploads efficiently.

### Custom Query Execution
- The use of custom queries in repositories like `UserRepository` and `MapPointRepository` adds flexibility in data retrieval, catering to specific requirements of the application.

## Interesting Features

### Dynamic Geographic Data Management
- `MapPointService` plays a crucial role in managing dynamic geographic information, which is central to the application's core functionality.

### Comprehensive User Handling
- The backend effectively handles various aspects of user management, from registration, authentication, to role-based access control.

### Environment-Aware File Storage
- `FileStorageService` dynamically sets up the file storage location based on the environment, showcasing an adaptable approach to resource management.

---
Overall, the backend development of our application exhibits a blend of solid architectural principles, security-focused practices, and efficient data handling. It is tailored to meet the demands of scalable, secure, and responsive web applications.

# CI/CD Implementation Overview

Our project employs a robust Continuous Integration and Continuous Deployment (CI/CD) strategy using GitHub Actions. This approach ensures that both the frontend and backend are built, tested, and deployed efficiently and independently.

## Key Aspects of CI/CD Workflows

### Backend Workflows

#### Development Workflow
- **Trigger**: Activated on pull requests to the `development` branch, specifically for changes in the `src` directory or the backend `Dockerfile`.
- **Process**:
  - Sets up Java environment using Java version 11.
  - Performs a Maven build, skipping tests for faster execution.
  - Builds a Docker image tagged with the backend latest version.
- **Purpose**: Ensures that every change in the backend codebase is automatically built and verified, maintaining code quality and integration.

#### Production Workflow
- **Trigger**: Runs on pushes to the `production` branch, targeting the `src` directory or Dockerfile changes.
- **Process**:
  - Similar setup and build process as the development workflow.
  - Includes steps to login to DockerHub, build and push Docker images.
  - Deploys the backend to a VM using SSH and Docker Compose.
- **Purpose**: Automates the deployment of the backend to the production environment, ensuring that the live application is always up-to-date with stable changes.

### Frontend Workflows

#### Development Workflow
- **Trigger**: Initiated on pull requests to the `development` branch, with changes in the `view` directory or its `Dockerfile`.
- **Process**:
  - Installs npm dependencies and builds the frontend application.
  - Builds a Docker image for the frontend, tagged as the latest version.
- **Purpose**: Guarantees that updates to the frontend are automatically built and tested, ensuring consistent performance and functionality.

#### Production Workflow
- **Trigger**: Executes on pushes to the `production` branch, monitoring the `view` directory or its Dockerfile.
- **Process**:
  - Similar frontend build process as in the development workflow.
  - Includes DockerHub login, image build and push.
  - Deploys the frontend to a VM using SSH and Docker Compose.
- **Purpose**: Facilitates the automated deployment of the frontend to the production environment, aligning the live application with stable and tested changes.

## Highlights of the CI/CD Strategy

- **Independent Workflows**: Frontend and backend are treated separately, allowing for targeted deployments. Changes in one do not unnecessarily trigger workflows for the other.
- **Environment Specific Triggers**: The separation of `development` and `production` workflows allows for different processes and checks, ensuring that deployments are environment-appropriate.
- **Containerized Deployment**: Both frontend and backend deployments leverage Docker, enhancing consistency across different environments and simplifying deployment processes.
- **Automated Testing and Building**: By automating the building and testing processes, the workflows ensure that the code is always in a deployable state.

---

This CI/CD setup plays a crucial role in the project's lifecycle, enhancing productivity, and ensuring reliability and stability of both the frontend and backend environments.

# Application Deployment Overview

Our application's deployment is meticulously designed to ensure seamless integration, security, and accessibility of both the frontend and backend components. Key elements include SSL configuration, Docker Compose setup, and Nginx reverse proxy.

## Docker Compose Configuration

### Backend Service
- **Image**: Uses `genius390/backend:latest`.
- **Volumes**: Includes a volume for photo storage.
- **Exposure**: Exposes port `8080`.
- **Environment**: Set to use the `docker` Spring profile.
- **Healthcheck**: Configured to ensure service health before dependency services start.

### Database Service
- **Image**: Based on `mysql:8.0.35`.
- **Volumes**: Dedicated volume for MySQL data.
- **Exposure**: Exposes port `3306`.
- **Environment**: MySQL root password and database name are set.
- **Healthcheck**: Ensures MySQL service is fully operational before dependent services start.

### Frontend Service
- **Image**: Uses `genius390/frontend:latest`.
- **Exposure**: Exposes port `80`.
- **Environment**: Configured with the API URL for backend communication.
- **Dependency**: Waits for the backend service to be healthy.

### Nginx Service
- **Image**: Based on `nginx:latest`.
- **Ports**: Binds ports `80` and `443` for HTTP and HTTPS traffic.
- **Volumes**: Configured for Nginx configuration, SSL certificates, and web root for certbot.
- **Dependency**: Depends on both frontend and backend services.

## SSL Configuration and Nginx Setup

### HTTP to HTTPS Redirection
- Redirects all HTTP traffic to HTTPS to ensure secure communication.

### SSL Certificates
- Utilizes Let's Encrypt certificates for SSL, ensuring encrypted communication.

### Backend API Routing
- Routes `/api/` requests to the backend container, enabling secure and direct access to the backend APIs.

### Frontend Routing
- Directs all other traffic to the frontend container, serving the React application over HTTPS.

## Interesting Features

### Separated Service Management
- Each component (frontend, backend, database) is managed separately, allowing for independent scaling and management.

### Health Checks
- Ensures that services are healthy before starting dependent services, reducing the risk of startup failures.

### Environment-Specific Configuration
- The use of environment variables and different Docker Compose profiles allows for flexible deployment across different environments.

### Security-First Approach
- SSL implementation and strict routing rules in Nginx enhance the security and integrity of the application.

---

This deployment strategy reflects a comprehensive approach, balancing the needs for security, performance, and scalability. It demonstrates a sophisticated understanding of modern web application deployment best practices.

# Project Documentation Summary

Our project is a comprehensive application that exhibits a blend of modern web development practices across its frontend and backend, coupled with a robust CI/CD pipeline. Below is a summary of the various components and aspects of the project:

## Backend Overview
- Developed using Java Spring Boot with a focus on RESTful API design.
- Features security and authentication mechanisms using JWT and BCrypt for password handling.
- Employs JpaRepository for efficient data handling and persistence.
- Modular architecture with dedicated services for specific functionalities like file storage and user management.

## Frontend Overview
- Built using React, offering a dynamic and responsive user interface.
- Implements React Router for navigation and uses state management techniques for a seamless user experience.
- Integrates with the backend through Axios for API calls.
- Leverages Bootstrap for styling and responsive design.

## CI/CD and Deployment
- Utilizes GitHub Actions for separate CI/CD workflows for frontend (`view` folder) and backend (`src` folder).
- Incorporates Docker for containerization and Nginx for reverse proxy and SSL configuration.
- The Docker Compose setup ensures seamless integration and deployment of all services.

## Additional Resources
- **Swagger API Documentation**: For a detailed overview of the API endpoints and their specifications, spin up project and then visit the [Swagger UI](http://localhost:8080/swagger-ui/index.html#/) for our project.
- This comprehensive API documentation is essential for understanding the available endpoints and their usage.

---

This documentation provides a holistic view of the project, outlining its structure, functionalities, and areas for future enhancements. It serves as a guide for understanding the application's architecture and operational dynamics.

