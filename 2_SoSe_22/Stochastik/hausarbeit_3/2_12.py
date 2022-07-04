import hashlib # hashlib für das Hashen der Kombinationen
import time # Time um die Dauer der Anwendung zu erhalten

# Das gesuchte Passwort
pw = "39228d06a988045c5caaa97bf0a6158893d51862"

# Die Methode um das Passwort zu finden.
def get_password(list_combination) -> str:
    count = 0
    # Durchlauf vom ersten Zeichen
    for a in list_combination:
        # Durchlauf vom zweiten Zeichen
        for b in list_combination:
            # Durchlauf vom dritten Zeichen
            for c in list_combination:
                # Durchlauf vom vierten Zeichen
                for d in list_combination:
                    # Durchlauf vom fünften Zeichen
                    for e in list_combination:
                        count += 1 # Zähler hochsetzten
                        word = bytes(a + b + c + d + e, 'utf-8') # die Kombination in UTF-8 Bytes konvertieren
                        hex = hashlib.sha1(word).hexdigest() # die Konbination in SHA1 hashen
                        if count % 10000000 == 0:
                            # nach 10M Kombinationen einen zwischen Stand abgeben
                            print(count / 1000000, "M")
                            print(word, " das aktuelle Wort")
                        if str(hex) == str(pw):
                            # wenn die Kombination als Hash genau gleich ist, wie vom angegebenen (gehashte) Passwort 
                            print("Nach ", count, " iterationen wurde das Passwort gefunden!")
                            return word # Abbruch der Iteration und gebe die gefunde Kombination zurück 
    return None # Wenn kein Passwort gefunden wurde, gebe None zurück

if __name__ == "__main__": 
    # Geht in die Schleife, wenn die Python-Datei der aktuelle Hauptprozess ist
    try:
        # Alle möglichen Zahlen als Liste.
        list_digits = [str(i) for i in range(10)]
        # Alle möglichen Großbuchstaben
        list_upper = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"]
        # Alle mögliche Kleinbuchstaben
        list_lower = [str(UpChar).lower() for UpChar in list_upper]

        # Kombiniere alle Möglichkeiten in eine Liste
        list_all = list_digits + list_upper + list_lower

        # aktuellen Zeitstempel am Startpunkt (in Sekunden)
        start = time.time()
        # Führe die Methode aus, um das Passwort zu finden 
        word = get_password(list_all)
        # aktuellen Zeitstempel am Endpunkt (in Sekunden)
        end = time.time()
        if (word is None):
            # Wenn keine Kombination gefunden wurde
            print("Es wurden kein Passwort gefunden! {} Sekunden gefunden.".format(round(end-start, 10)))
        else:
            # Wenn das Passwort gefunden wurde
            # Gebe die Dauer der Anwendung zurück
            #       - Die Dauer wird berechnet aus dem End-Zeitstempel minus dem Start-Zeitstempel
            print("Das Passwort wurde in {} Sekunden gefunden.".format(round(end-start, 10)) ) 
            # Gebe das Passwort gefunde Passwort zurück
            print("Das Passwort ist =", word)

    except Exception as e:
        # Sollt es zu einer Exception kommen,
        # gebe diese in der Konsole zurück
        print(e)

# ANWENDUNG WIRD HIER BEENDET

"""OUTPUT
...
...
410 M
b'RkJjD'  das aktuelle Wort
Nach  413927194  iterationen wurde das Passwort gefunden!
Das Passwort wurde in 434.2671899796 Sekunden gefunden.
Das Passwort ist = b'S0nN3'
"""
