JAK DOSTAC PLIK .JAR BEZ INSTALOWANIA JAVY:
1. Zaloz darmowe konto na github.com i nowe repozytorium (Create new repository).
2. Wrzuc tam cala zawartosc tego folderu (Add file -> Upload files; razem z ukrytym folderem .github).
3. Wejdz w zakladke Actions -> build -> kliknij ostatnie uruchomienie.
4. Na dole w sekcji Artifacts pobierz pole-smierci-jar (w srodku jest plik .jar).
5. Plik .jar wrzuc do folderu mods (Minecraft 1.21.4, Fabric Loader + Fabric API).

Lokalnie: gradle build  (Java 21) -> build/libs/pole-smierci-1.0.0.jar
