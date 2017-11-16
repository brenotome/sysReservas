assentos = [0, 0, 0, 0, 0]

def op1(tid,vet):
    if vet != assentos:
        print "ERRO"

def op2(tid,pos,vet):
    if(assentos[pos]==0):
        assentos[pos]=tid
    if vet != assentos:
        print "ERRO"

def op3(tid,pos,vet):
    if(assentos[pos]==0):
        assentos[pos]=tid
    if vet != assentos:
        print "ERRO"

def op4(tid,pos,vet):
    if(assentos[pos]==tid):
        assentos[pos]=0
    if vet != assentos:
        print "ERRO"
