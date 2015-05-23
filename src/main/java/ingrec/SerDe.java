package ingrec;

import java.util.ArrayList;
import java.util.List;

import org.apache.thrift.TDeserializer;
import org.apache.thrift.TException;
import org.apache.thrift.TSerializer;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.testng.annotations.Test;

/**
 * Created by karishma.gulati on 12/05/15.
 */
public class SerDe {
    TSerializer serializer = new TSerializer(new TBinaryProtocol.Factory());
    TDeserializer deserialiser = new TDeserializer(new TBinaryProtocol.Factory());
   
    listIDS obj = new listIDS();
    List<Integer> idlist = new ArrayList<Integer>();
    byte[] serialisedByte = null;
    
    @Test
    public void serialiseMyData() {
    	
        for (int i = 0; i < 10; ++i) {
            idlist.add(i);
        }
        obj.setRecipeIDs(idlist);
        try {
            serialisedByte = serializer.serialize(obj);
        }catch(TException e){
            e.printStackTrace();
        }
        System.out.println("The serialised Data is : " + serialisedByte);
        deSerialiseMyData();
    }

    
    public void deSerialiseMyData() {
        try {
            listIDS deserialisedObj = new listIDS();
            deserialiser.deserialize(deserialisedObj, serialisedByte);
            List<Integer> newList = deserialisedObj.getRecipeIDs();
            //Now display list to see you got back the same data
            System.out.println(newList);
        }catch(TException e){
            e.printStackTrace();
        }
    }

}
