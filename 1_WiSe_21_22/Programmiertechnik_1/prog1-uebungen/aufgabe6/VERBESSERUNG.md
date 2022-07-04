
> Leistung/Rating.java ist von mir als Entitätsklasse spezifiziert. 
> Deshalb darf equals und hashCode nicht überschrieben werden.
> Die Implementierungen sind auch Unsinn, weil sie nicht auf den
> Instanzvariablen beruhen. Es gibt im übrigen auch keine korrekte 
> Implementierung, siehe unser Versuch mit OrtsTermin.

> In HtmlFormatter und TextFormatter sollten Sie nicht mit instanceof
> programmieren. Das ist an dieser Stelle sehr schlechter Stil.
> Die Formatter sollen die Namen der Unterklassen gar nicht kennen.
> Diese Abstraktion ist ja gerade die Staerke der Objektorientierung.
> Es gibt extra fuer den Zweck die Methode istBenoted/isGraded.

> Es ist keine gute Idee, Name und Ort der Ausfgabedatei in HtmlFormatter
> festzulegen. Dem Formatierer sollte egal sein, wohin sein String geht.
> Bei gutem objektorientiertem Stil sollten Klassen immer moeglichst
> flexibel einsetzbar sein ("Lego-Software"). Halten Sie sich an die Vorlage, 
> bei der die Datei in der Main-Klasse festgelegt wird.

> Der Umlaut ue in fuer wird nicht richtig dargestellt.
> Ihr .java-Quelltext ist in utf-8 kodiert, aber das versteht javac nicht, 
> wenn man ihm das nicht mit einer speziellen Option sagt. Diese Option habe ich 
> in build.xml nicht eingebaut. Aus dem Zwei-Byte-Code des ue werden dadurch 
> im Output zwei 1-Byte-Zeichen. Schreiben Sie wie in der Vorlage BennoBeispiel.html 
> die HTML-Ersatzdarstellung &uuml; fuer das ue.

> TextFormatter ist nicht wie verlangt in die Main-Klasse eingebaut.

> Sie haben sich in Ihrer Version von suppressions.xml einen Freibrief
> fuer magic numbers in allen Klassen gegeben. Das ist nicht in Ordnung.


> Nebenbemerkung:

> Die englisch Umbenennerei war bei dieser Aufgabe keine gute Idee,
> weil das die Korrektur fuer mich sehr aufwaendig macht.

