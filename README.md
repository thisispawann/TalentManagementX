# Talent Management X

## Overview
Talent Management X is a Groovy and Grails-based application designed to streamline the management of employee records, leave applications, and salary information. This project leverages Groovy 8.11 and Grails 5.3.5, incorporating salt hashing for secure password management and the Aspose library for exporting records.

## Features
- **User Roles**:
  - **Manager**:
    - Handle CRUD operations for employee records.
    - Manage leave and salary records.
    - Export functionality for reports.
    - Approve or reject employee leave applications.
  - **Employee**:
    - Register and log in to the system.
    - Apply for leave applications.
    - View all employee records but can only update their own.

## Technologies Used
- **Groovy**: Version 8.11
- **Grails**: Version 5.3.5
- **Salt Hashing**: For secure password storage.
- **Aspose Library**: For exporting records in various formats.
- **H2 Database**: For storing and managing records.

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 11 or higher.
- Groovy 8.11 installed.
- Grails 5.3.5 installed.

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/thisispawann/TalentManagementX.git
   cd TalentManagementX

### Install dependencies:
- grails clean
- grails compile
- grails install-app

## Running the application:
- grails run-app

  And access the application at 'http://localhost:8080'.
