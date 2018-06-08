/*
 * 
 */
package musicaplayerofficial.Arvores;

/**
 *
 * @author cadoafb
 * @param <Type>
 */
public class ArvoreBinariaBusca<Type extends Comparable> {
    
     private No<Type> raiz;

    public ArvoreBinariaBusca() {
        this.raiz = null;
    }
     
    public boolean isEmpty(){
        return raiz == null;
    }
    
    public No<Type> insert(Type element) {
        return this.insert(new No(element), raiz);
    }

    
    private No<Type> insert(No<Type> novoNo, No<Type> noAnterior) {
        if (this.raiz == null) {
            raiz = novoNo;
            return raiz;
        }
        
        if (novoNo.getValue().compareTo(noAnterior.getValue()) < 0) {
            if (noAnterior.getFilhoEsquerda() == null) {
                noAnterior.setFilhoEsquerda(novoNo);
                return noAnterior.getFilhoEsquerda();
            } 
            else {
                return insert(novoNo, noAnterior.getFilhoEsquerda());
            }
        } 
        else if (novoNo.getValue().compareTo(noAnterior.getValue()) > 0) {
            if (noAnterior.getFilhoDireita() == null) {
                noAnterior.setFilhoDireita(novoNo);
                return noAnterior.getFilhoDireita();
            } 
            else {
                    return insert(novoNo, noAnterior.getFilhoDireita());
                }
        }

        return null;
    }
    
    
    public int getAltura(){
        return getAltura(this.raiz);
    }
    
    private int getAltura(No<Type> _raiz){
        if(_raiz == null){
            return 0;
        }
        int altEsq = getAltura(_raiz.getFilhoEsquerda());
        int altDir = getAltura(_raiz.getFilhoDireita());
        if(altEsq > altDir)
            return altEsq + 1;
        else 
            return altDir + 1;
    }
    
    public int getProfundidade(No<Type> _No) {
        return getProfundidade(_No, raiz);
    }


    private int getProfundidade(No<Type> _No, No<Type> father) {
        if (_No == null || father == null) {
            return -1;
        }

        if (_No == father) {
            return 0;
        }
        
        int profundidade;
        
        if(father.getValue().compareTo(_No.getValue()) < 0)
            profundidade = getProfundidade(_No,father.getFilhoDireita());
        else
            profundidade = getProfundidade(_No,father.getFilhoEsquerda());

        
        if(profundidade != -1)
            return profundidade + 1;
        else
            return -1;
                
    }
    
    public No<Type> getMenorElemento() {
        return getMenorElemento(raiz);
    }

    private No<Type> getMenorElemento(No<Type> _No) {
        if (_No == null) {
            return null;
        }

        if (_No.getFilhoDireita()== null) {
            return _No;
        }

        return getMenorElemento(_No.getFilhoEsquerda());
    }
    
    public No<Type> getMaiorElemento() {
        return getMaiorElemento(raiz);
    }

    private No<Type> getMaiorElemento(No<Type> _No) {
        if (_No == null) {
            return null;
        }

        if (_No.getFilhoDireita()== null) {
            return _No;
        }

        return getMaiorElemento(_No.getFilhoDireita());
    }
    
    public No<Type> busca(Type val) {
        return busca(val, raiz);
    }

    
    private No<Type> busca(Type val, No _No) {
        if (_No == null) {
            return null;
        }

        if (_No.getValue().compareTo(val) < 0) {
            return busca(val, _No.getFilhoDireita());
        }

        if (_No.getValue().compareTo(val) > 0) {
            return busca(val, _No.getFilhoEsquerda());
        }

        return _No;
    }
    
    
    public void imprimeEmOrdem() {
        System.out.print("[ ");
        imprimeEmOrdem(raiz);
        System.out.println(" ]");
    }
    
    private void imprimeEmOrdem(No<Type> _No) {
        if (_No != null) {
            imprimeEmOrdem(_No.getFilhoEsquerda());
            System.out.print(" " + _No.getValue());
            imprimeEmOrdem(_No.getFilhoDireita());
        }
    }

}

    
