
TARGET = hello

LATEX = pdflatex

.PHONY: all clean
	
all: $(TARGET).pdf

clean:
	rm *.pdf *.aux *.log

%.pdf: %.tex	
	$(LATEX) $^
