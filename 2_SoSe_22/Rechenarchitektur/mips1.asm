addi $s0, $zero, 122 	# a = 122
addi $s1, $zero, 12 	# b = 12
bgt $s1, $s0, negativ	# if ($s1 > $s0) [b > a] { jump to negativ }
sub $s2, $s0, $s1		# c = abs(a-b) == a-b 
j weiter			# jump to weiter
negativ: 		# if b greater than a
sub $s2, $s1, $s0		# c = abs(a-b) == b-a
weiter:			# weiter 
# continue ...
