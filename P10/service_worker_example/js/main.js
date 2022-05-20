// Registracija service workera
// Provera na chrome://inspect/#service-workers i chrome://serviceworker-internals
// Dokumentacija https://developers.google.com/web/fundamentals/primers/service-workers
if ('serviceWorker' in navigator) {
  window.addEventListener('load', () => {
    navigator.serviceWorker
      .register('../sw.js')
      .then(reg => console.log(`Service Worker successfully registered with scope: ${reg.scope}`))
      .catch(err => console.log(`Service Worker registration failed: ${err}`));
  });
}
