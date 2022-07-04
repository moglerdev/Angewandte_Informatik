# Schreiben Sie ein Makefile aufgabe6/bonus.mak, das Ihre Lösung von
# Aufgabe 6 in eine Datei aufgabe6.tar.gz verpackt.
# Halten Sie alle besprochenen Stilregeln für ein gutes Makefile ein.
# Das Makefile muss mit der Option -R ausführbar sein.

TAR_NAME = aufgabe6.tar.gz
TAR = tar cvzf $(TAR_NAME) *

.PHONY: all clean

all clean: $(clean)
	rm -f $(TAR_NAME)
	$(MAKE) -R clean
	$(TAR)
