.data
size: .word 24
array: .word 1, 2, 3, 4, 5, 6  # a[6] = { 1, 2, 3, 4, 5, 6 }

.text
main:
li $t0, 0 # i = 0
lw $t1, size
li $s0, 0 # sum = 0

loop1:
bge $t0, $t1, exit
lw $t2, array($t0)
add $s0, $s0, $t2
addi $t0, $t0, 4
j loop1
exit:
