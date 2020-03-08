package estruturadedadosavancada.GenericTree;

import java.util.ArrayList;
import java.util.List;

public class GenericNode<Index, E> {
	public Index index; // data item (key)
	public E data; // data item
	public GenericNode<Index,E> father; 
	public List<GenericNode<Index,E>> children; 

    public GenericNode(Index index) {
        this.index = index;
        this.father = null;
        this.children = new ArrayList<>();
    }
        
    public GenericNode(Index index, E data) {
        this.index = index;
        this.data = data;
        this.father = null;
        this.children = new ArrayList<>();
    }
    
    public E getData(){
        return this.data;
    }

    public void setData(E data) {
        this.data = data;
    }
    
    public void setFather(GenericNode<Index,E> father){
        this.father = father;
    }
}
