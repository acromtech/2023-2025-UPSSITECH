# -*- coding: utf-8 -*-
"""
version simple comptage mots d'un fichier

test sur Alice in Wonderland
"""

import sys


def comptage(liste_items):
    res = {}
    for one in liste_items:
        res[one] = res.get(one,0) + 1
    return res


def normalise(mot):
    res = mot.strip().replace("'","").lower()
    return res

# 1) version bourrine
ponct = set(",;?.:-!&'()")
stop_words = set("""one the a some no not is be are has have been had must can do may might and of in i you we she he it they what if s ll t m re
as out to at with her his their theirs our ours its your my mine did an was on as for this that who when were would me herself himself themselves just 
could should all but or so very what about there then them by any well don haven weren isn
gutenberg project fundation""".split())

def enleve_ponctuation(text):
    res = text
    for sign in ponct:
        res = res.replace(sign," ")
    return res

def list_tokens(text):
    new = enleve_ponctuation(text)
    mots = [normalise(mot) for mot in new.split() if normalise(mot) not in stop_words]
    return mots
    
def stats_text(text):
    mots = list_tokens(text)
    return comptage(mots)
        
############################## 
raw = open(sys.argv[1]).read().strip()
stats = stats_text(raw)
sorted_stats = [(y,x) for (x,y) in list(stats.items())]
sorted_stats.sort()
sorted_stats.reverse()
# alternativement: 
#sorted_stats = sorted(stats.items(),key=lambda x:x[1],reverse=True)
print("mots les plus fréquents, hors stopwords:")
print(sorted_stats[:50])

################################
# 2) version sur text tagué
def read_conll(filename):
    res = []
    for line in open(filename):
        (forme,tag,lemme) = line.strip().split()
        if lemme == '<unknown>':
            lemme = forme
        res.append((forme,tag,lemme))
    return res


stop_words2 = ["Project","Gutenberg","be","get","do","have",",",":",";","''","'",'"',]

def filtre_cat(items,
               cible=set(["MD","CC","DT","PP","PP","SE","SY","RP","WR","RB","TO","IN"]),
               keep = False): 
    if keep:
        return [(f,tag,l) for (f,tag,l) in items if tag[:2] in cible]
    else:
        return [(f,tag,l) for (f,tag,l) in items if tag not in cible]

def filtre_words(items,jeter=set(stop_words2)):
    return [(f,tag,l) for (f,tag,l) in items if l not in jeter]



def comptage_tagged(items):
    compt = {}
    for (f,tag,l) in items:
        forms  = compt.get(l,{})
        forms[f] = forms.get(f,0) + 1
        compt[l] = forms
    return compt
    
def stats_tagged(items):
    compt = comptage_tagged(items)
    total = {x:sum(compt[x].values()) for x in compt}
    return total, compt

def best_lemmas(items,nb):
    total,compt = stats_tagged(items)
    best = sorted(list(total.items()),key=lambda x:x[1],reverse=True)[:nb]
    return [(x,compt.get(x,{})) for (x,n) in best]

try:
    tagged = read_conll("alice_wonderland.utf8.conll")
except IOError as e :
    print("fichier manquant ? ")
    raise e
else:
    text = filtre_words(filtre_cat(tagged,cible=set(["NN"]),keep=True))
    #comparer: text = filtre_words(filtre_cat(tagged))    
    print("="*50)
    print("noms les plus fréquents, avec leurs formes")
    res =  best_lemmas(text,20)
    for lemme,cnt in res:
        print(lemme)
        print("\t\t", "\n\t\t".join(["%s:%s"%x for x in list(cnt.items())]))
    

###########  same bigrams, ngrams ... 
def list_bigrams(items):
    res = []
    for (i,w) in enumerate(items[1:]):
        res.append((items[i],w))
    return res

# plus général
def list_ngrams(items,n):
    res = []
    for (i,w) in enumerate(items[n-1:]):
        res.append(" ".join(items[i:i+n]))
    return res


def stats_ngrams(text,n=2):
    mots = list_tokens(text)
    bigrams = list_ngrams(mots,n)
    return comptage(bigrams)

n = 3
stats = stats_ngrams(raw,n=n)
sorted_stats = sorted(list(stats.items()),key=lambda x:x[1],reverse=True)
print("="*50)
print("liste de ngrams, n = %d \n "%n)
print("\n".join(["%s (%s)"%x for x in sorted_stats[:50]]))


