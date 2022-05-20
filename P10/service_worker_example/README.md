# Primer keširanja statičkih resursa za offline korišćenje pomoću service workera

U primeru je predstavljena ideja o keširanju statičkih resursa za offline mode pomoću servise workera.

Service worker lifecycle je plastično prikazan na slici (slika preuzeta sa [linka](https://developers.google.com/web/fundamentals/primers/service-workers)):

![alt text](https://developers.google.com/web/fundamentals/primers/service-workers/images/sw-lifecycle.png "Service Worker Lifecycle")

## Korisne stvari
* [VS code](https://code.visualstudio.com/)
* [Live Server](https://marketplace.visualstudio.com/items?itemName=ritwickdey.LiveServer)
* [Service Workers](https://developers.google.com/web/fundamentals/primers/service-workers)
* [Service Workers Security FAQ](https://chromium.googlesource.com/chromium/src/+/master/docs/security/service-worker-security-faq.md)


## Pokretanje aplikacije

* Otvoriti __service_worker_example__ u VS Code editoru
* Ako je instaliran Live Server, kliknuti na "Go Live" u dnu VS Code i aplikacija će se servirati na __127.0.0.1__ i otvoriti u pretraživaču
