# Employee Management System

![Angular](https://img.shields.io/badge/Angular-DD0031?logo=angular&logoColor=white)
![TypeScript](https://img.shields.io/badge/TypeScript-3178C6?logo=typescript&logoColor=white)

> A single-page application for managing employee records — create, list, edit, and remove employees — built with Angular 11 and TypeScript.

This project demonstrates a clean Angular architecture: feature components, services for data access, reactive forms with validation, and client-side routing.

## Features

- List employees in a table
- Create and edit employees with reactive-form validation
- Delete with confirmation
- Client-side routing between views

## Tech stack

| Layer | Technology |
|-------|-----------|
| Framework | Angular 11 |
| Language | TypeScript |
| Tooling | Angular CLI, Karma (unit), Protractor (e2e) |

## Getting started

### Prerequisites
- Node.js 16+ and npm
- Angular CLI (`npm install -g @angular/cli`)

### Run locally
```bash
git clone https://github.com/GitMarlonATA/sistemaGestionEmpleados.git
cd sistemaGestionEmpleados
npm install
ng serve
```

Open http://localhost:4200 — the app reloads automatically on source changes.

## Tests
```bash
ng test        # unit tests (Karma)
ng e2e         # end-to-end tests
```

## Build
```bash
ng build --prod   # outputs to dist/
```

## Roadmap
- [ ] Connect to a live REST backend (see my `ledger-service` repo for a Spring Boot API)
- [ ] Add pagination and server-side filtering
- [ ] Migrate to a current Angular LTS version

---
Built by [Marlon Ticora](https://github.com/GitMarlonATA) · [LinkedIn](https://www.linkedin.com/in/marlon-augusto-ticora-alvarez-fullstack-ml/)
