# TeraBox Currency

Android app for 💱 currency conversion with a TeraBox integration boundary.

## Current state

- Currency calculation is implemented and covered by unit tests.
- Android Compose build configuration is enabled.
- Network permission is enabled for future cloud API calls.
- TeraBox adapter is credential-free until an official Open Platform application/API contract is configured.
- The app includes an **Open TeraBox** action that launches TeraBox in the browser.

## TeraBox integration

The project does not embed passwords, access tokens, client secrets, or guessed API endpoints. When TeraBox Open Platform credentials and the official endpoint contract are available, implement them behind `CloudStorageAdapter` / `TeraBoxAdapter`.

## Build

```bash
gradle test
gradle assembleDebug
```

The GitHub Actions workflow runs both commands on pushes and pull requests to `main`.
