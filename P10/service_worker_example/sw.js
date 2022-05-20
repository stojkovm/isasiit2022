const CACHE_NAME = 'v1';

const cacheAssets = [
  'index.html',
  'about.html',
  '/css/style.css',
  '/js/main.js',
  '/images/voks.jpg',
  '/images/voka.jpg',
  '/images/voki.jpg'
];

// Instalacija SW
self.addEventListener('install', e => {
  console.log('Service Worker: Installed');

  e.waitUntil(
    caches
      .open(CACHE_NAME)
      .then(cache => {
        console.log('Service Worker: Caching Files');
        cache.addAll(cacheAssets);
      })
      .then(() => self.skipWaiting())
  );
});

// Aktivacija novog sw
self.addEventListener('activate', e => {
  console.log('Service Worker: Activated');
  // Brisanje starog kesa
  e.waitUntil(
    caches.keys().then(cacheNames => {
      return Promise.all(
        cacheNames.map(cache => {
          if (cache !== CACHE_NAME) {
            console.log('Service Worker: Clearing Old Cache');
            return caches.delete(cache);
          }
        })
      );
    })
  );
});

// Serviranje iz kesa
self.addEventListener('fetch', e => {
  console.log('Service Worker: Fetching response');
  e.respondWith(fetch(e.request).catch(() => caches.match(e.request)));
});
