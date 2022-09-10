[![Java CI with Maven](https://github.com/Rikatob/YatziPairProg/actions/workflows/maven.yml/badge.svg)](https://github.com/Rikatob/YatziPairProg/actions/workflows/maven.yml)
# Yatzi  [Amund Fredrik]

#Steg 1: Kom i gang med testing via Github med Maven

* [x] Finn noen å jobbe sammen med. For bonuspoeng kan du jobbe sammen med noen du ikke kjenner
* [x] En av utviklerne oppretter et nytt repository på Github og legger til den andre som collaborator
* [x] En av dere laster ned prosjektet i IntelliJ: File > New > Project from version control
* [x] Gjør om prosjektet til et Maven prosjekt
* [x] PASS PÅ Å OPPRETTE EN .gitignore-fil
* [x] Legg til en test under src/test/java. Testen skal teste et yatsi-kast, for eksempel at dersom terningene plasseres på "sjanse" skal man få summen av øyne på terningene som score. For å få definert testen må du sette opp maven-compiler-plugin og legge til junit-jupiter som en dependency i pom.xml
* [x] Sjekk at testen kjører rødt, commit og push
* [x] Den andre utvikleren laster også ned prosjektet i IntelliJ. IntelliJ vil nå automatisk oppdage at det er et Maven-prosjekt
* [x] Implementer tilstrekkelig kode for at testen kjører grønt og commit
* [x] Opprett en ny test, for eksempel å teste at for når en spiller plasserer kastet på "enere" skal hen får summen av alle terningene med én som score
* [x] Sjekk at testen kjører rødt, commit og push
* [x] Den andre utvikleren implementerer koden som skal til for å kjøre grønt, committer og pusher
#Steg 2: Github Actions

* [x] Github hjelper dere å opprette en action for å kjøre Maven (pass på at dere ikke velger DEPLOY med Maven). Se om dere finner den under Actions valget på github.com
* [x] Når dere setter opp Action-en vil den kjøre 0 tester. Dette er fordi maven-surefire-plugin som Maven bruker for å kjøre tester må ha en annen versjon enn det som er standard (se gjerne notatene fra forelesning for å finne ut hvordan). Dere må også passe på at dere bruker junit-jupiter og ikke junit-jupiter-api som dependency
* [x] Når dere har rettet pom.xml for å få Github Actions til å kjøre med Maven kan dere legge inn action-surefire-report (Lenker til en ekstern side.)
* [x] Når Actions kjører korrekt kan dere legge til en Badge i README.md

#Steg 3: Pull request

* [x] Fortsett på yatzi-oppgaven med toere. MEN FØR DERE STARTER, opprett en ny branch med navnet `feature/score-twos`
* [x] Jobb gjerne ping-pong som tidligere. Legg merke til at Actions ikke kjører testene fordi dere er på en branch
* [x] Gå til "pull requests" under github.com for å opprette en pull request av branchen
* [x] Den som ikke opprettet pull requesten kan skrive noen review-kommentarer av pull requesten
* [x] Merge pull requesten
* [x] Se på commit-loggen hvordan pull requesten inngår i Git loggen
* [ ] Opprett en ny branch for `feature/score-pair` (denne bør ha minst to test-cases for å sikre at man ikke hardkoder svaret)
* [ ] Prøv å opprette en pull request og Squash Merge denne
* [ ] Sammenlign hvordan de to måtene å merge ser annerledes ut i Git loggen 
