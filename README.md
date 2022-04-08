# Cascading-arrays

Tabela tabel je podatkovna struktura, ki vsebuje k pod-tabel Ai (i = 0 .. k-1) fiksnih velikosti 2i. Osnovna
implementacija predpostavlja, da so pod-tabele bodisi prazne ali popolnoma polne, kar pomeni, da
si pri tabeli tabel z n elementi lahko pomagamo z binarno predstavitvijo števila n za predočitev
informacije, katera pod-tabela je prazna (binarna števka 0) ali polna (binarna števka 1). 

# Operacija insert(), klasični postopek:
Element, ki ga vstavljamo naj tvori začetno začasno tabelo Atmp = [e].
Nato obiskujemo pod-tabele od i = 0 do k-1:
če je pod-tabela Ai prazna, ji dodelimo Atmp in, če je i > 0, še “izpraznimo” vse pod-tabele od
Ai-1 do A0 , ter uspešno zaključimo vstavljanje …
sicer v Atmp urejeno zlijemo Atmp in Ai, ter nadaljujemo na Ai+1 …
V kolikor so vse pod-tabele neprazne, potem tvorimo novo, dodatno pod-tabelo Ak (velikosti 2k), ji
dodelimo Atmp in, ker je i > 0, še “izpraznimo” vse dosedanje pod-tabele od Ak-1 do A0, ter uspešno
zaključimo vstavljanje.
Časovna zahtevnost operacije insert() je O(n), ker v najslabšem primeru z vstavljenim elementom [e]
urejeno zlijemo vse A0 do Ak-1 pod-tabele v novo, dodatno pod-tabelo Ak.

# Operacija find(), klasični postopek:
Z iskanim elementom e obiskujemo pod-tabele od i = 0 do k-1:
če je pod-tabela Ai prazna, nadaljujemo na Ai+1 …
če je e enak min ali max elementu pod-tabele Ai, potem uspešno zaključimo iskanje …
če je e manjši od min ali večji od max elementa pod-tabele Ai, nadaljujemo na Ai+1 …
v pod-tabeli Ai izvedemo dvojiško iskanje elementa e in, če ga najdemo, uspešno zaključimo
iskanje, sicer nadaljujemo na Ai+1 …
V kolikor smo do sem pregledali vse pod-tabele, potem lahko iskanje neuspešno zaključimo.
Časovna zahtevnost operacije find() je O(lg^2(n)), ker v najslabšem primeru element e dvojiško iščemo
v vsaki od A0 do Ak-1 pod-tabel.

# Operacija delete(), klasični postopek:
Želeni element leno izbrišemo, kar pomeni, da ostane na istem mestu in je oznacen kot izbrisan da se ne podre struktura tabele.
Pri vstavljanju nato preverimo če se kakšen leno označen element pojavi pred prazno tabelo in ju zamenjamo.
