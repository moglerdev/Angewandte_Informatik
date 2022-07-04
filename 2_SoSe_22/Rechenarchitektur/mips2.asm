addi $s0, $zero, 0 	# a = 0
addi $s1, $zero, 1 	# b = 1
addi $s3, $zero, 10 	# n = 10
bge $zero, $s3, exit # if n <= 0 { jump to exit; }
loop:
add $s2, $s0, $s1	# c = a +b
add $s0, $zero, $s1	# a = b
add $s1, $zero, $s2	# b = c
addi $s3, $s3, -1  	# n = n - 1
bgt $s3, $zero, loop # if n > 0 { jump to loop; }
exit:
# continue ...