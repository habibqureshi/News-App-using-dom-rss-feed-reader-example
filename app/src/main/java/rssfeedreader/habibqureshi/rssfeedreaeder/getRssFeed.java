package rssfeedreader.habibqureshi.rssfeedreaeder;

import android.os.AsyncTask;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


/**
 * Created by HabibQureshi on 9/25/2017.
 */

public class getRssFeed extends AsyncTask<String,Void,List> {
    returnData data;
    public getRssFeed(returnData data) {
        super();
        this.data=data;

    }

    @Override
    protected void onPostExecute(List list) {
        super.onPostExecute(list);
        data.getData(list);
    }

    @Override
    protected List doInBackground(String... params) {
        try {
            URL url=new URL(params[0]);
            HttpURLConnection connection= (HttpURLConnection) url.openConnection();
            InputStream inputStream=connection.getInputStream();
            DocumentBuilder doc= DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document=doc.parse(inputStream);
            inputStream.close();
            connection.disconnect();
            return MapDataToClass(document.getDocumentElement().getElementsByTagName("item"));

        } catch (Exception e) {
            M.l(e.getMessage().toString());
        }
        return null;
    }
    public List MapDataToClass( NodeList list){
        int size=list.getLength();
        NodeList child;
        int childSize;
        Node currentNode;
        gadgets360 data;
        List<gadgets360> allData;
        allData=new ArrayList<>();
        for (int i = 0; i <size ; i++) {
            data= new gadgets360();
            child =list.item(i).getChildNodes();
            childSize =child.getLength();
            for (int j = 0; j < childSize; j++) {
                currentNode=child.item(j);
                switch (currentNode.getNodeName()){
                    case "title":
                        data.setTittle(currentNode.getTextContent());
                        break;
                    case "link":
                        data.setLink(currentNode.getTextContent());
                        break;
                    case "updatedAt":
                        data.setUpdatedAt(currentNode.getTextContent());
                        break;
                    case "pubDate":
                        data.setPubDate(currentNode.getTextContent());
                        break;
                    case "fullimage":
                        data.setStoryImage(currentNode.getTextContent());
                        break;
                    case "category":
                        data.setCategory(currentNode.getTextContent());
                        break;
                    case "description":
                        data.setDescription(currentNode.getTextContent());
                        break;
                }
            }
            allData.add(data);
        }
        return allData;
    }
}
