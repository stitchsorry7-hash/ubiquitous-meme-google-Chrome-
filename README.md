# TeraBox Currency

Android app for 💱 currency conversion with a provider-neutral TeraBox cloud integration boundary.

## Implemented

- Currency calculation with unit tests.
- Android Compose build configuration.
- CloudStorageAdapter + TeraBoxAdapter boundary.
- CloudSyncService for backup/restore delegation.
- Cloud sync service unit tests using an in-memory fake provider.
- Network permission for future cloud API calls.
- GitHub Actions test + debug APK build.
- **Open TeraBox** action from the app.

## TeraBox integration status

The app is structured so application data can be backed up/restored through `CloudSyncService` without coupling the UI to a cloud provider.

The real TeraBox network implementation is intentionally not enabled yet. It requires the official TeraBox Open Platform application registration, OAuth configuration, and the provider's current API endpoint/contract. The project does not embed passwords, access tokens, client secrets, or guessed endpoints.

Once the official contract is available, implement the HTTP/OAuth details only inside `TeraBoxAdapter`; the rest of the app can remain unchanged.

## Build

```bash
gradle test
gradle assembleDebug
```

GitHub Actions runs both commands on pushes and pull requests to `main` and publishes the debug APK as an artifact.
