n1, n2 = map(int, (input().split()))

k = 2
gcd = 1
while k <= n1 and k <= n2 :
    if n1 % k == 0 and n2 % k == 0 :
        gcd = k
    k += 1

lcm = gcd * (n1 // gcd) * (n2 // gcd)

print(gcd)
print(lcm)