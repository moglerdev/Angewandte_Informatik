make clean
make -R all
bin/notenspiegel < ./notenspiegel-in.txt
make -R clean
make -R LIBTYPE=so
ldd bin/notenspiegel < ./notenspiegel-in.txt
LD_LIBRARY_PATH=lib ldd bin/notenspiegel < ./notenspiegel-in.txt
LD_LIBRARY_PATH=lib bin/notenspiegel < ./notenspiegel-in.txt