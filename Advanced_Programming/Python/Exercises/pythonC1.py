def test():
    print ("test")
    return

def withoutDouble(l):
    res=[]
    for i in range (len(l)):
        if i==0 :
            res.append(l[i])
        elif l[i]!=l[i-1]: 
            res.append(l[i])
    return res

def consecutif(l):
    res=[]
    for i in range (l,len(l)):
        if l[i]==l[i-1]+1:
            res.append((l[i-1],l[i]))
    return res

def unique_trie(l):
    res=[]
    if len(l)>0:
        res.append(l[0])
    for i in range (1,len(l)):
        if l[i]!=l[i-1]:
            res.append(l[i])
        
    return res

def combinaison():
    res={}
    for d1 in range (1,7):
        for d2 in range (1,7):
            if d1+d2 in res :
                res[d1+d2].append((d1,d2))
            else:
                res[d1+d2]=[(d1,d2)]
    return res

#print(withoutDouble([1,1,1,2]))
#print(withoutDouble([1,2,3,4]))
#print(withoutDouble([1,1,1,1]))

