package estruturadedadosavancada.BinaryTreeArray;

import java.util.Objects;


public class BinaryNodeVector<Index, E> {
	public Index index; // data item (key)
	public E data; // data item

   public BinaryNodeVector(Index index) {
        this.index = index;
    }
        
    public BinaryNodeVector(Index index, E data) {
        this.index = index;
        this.data = data;
    }
    
    public E getData(){
        return this.data;
    }

    public void setData(E data) {
        this.data = data;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.index);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BinaryNodeVector<?, ?> other = (BinaryNodeVector<?, ?>) obj;
        if (!Objects.equals(this.index, other.index)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.index.toString();
    }

}
