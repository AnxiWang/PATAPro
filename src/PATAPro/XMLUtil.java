package PATAPro;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class XMLUtil{
public Document merge(String expression, String strMain, String strVice) throws Exception {
	    XPathFactory xPathFactory = XPathFactory.newInstance();
	    XPath xpath = xPathFactory.newXPath();
	    XPathExpression compiledExpression = xpath.compile(expression);
		ByteArrayInputStream streamMain = new ByteArrayInputStream(strMain.getBytes("UTF-8")); 
		ByteArrayInputStream streamVice = new ByteArrayInputStream(strVice.getBytes("UTF-8")); 

	    return merge(compiledExpression, streamMain, streamVice);
	  }

	  private static Document merge(XPathExpression expression,  
			  InputStream streamMain, InputStream streamVice) throws Exception {
	    DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
	    docBuilderFactory.setIgnoringElementContentWhitespace(true);
	    DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
	    Document base = docBuilder.parse(streamMain);
	   
	    Node results = (Node) expression.evaluate(base, XPathConstants.NODE);
	    if (results == null) {
	      throw new IOException(streamMain
	          + ": expression does not evaluate to node");
	    }

	//    for (int i = 1; i < files.length; i++) {
	      Document merge = docBuilder.parse(streamVice);
	      Node nextResults = (Node) expression.evaluate(merge,
	          XPathConstants.NODE);
	      while (nextResults.hasChildNodes()) {
	        Node kid = nextResults.getFirstChild();
	        nextResults.removeChild(kid);
	        kid = base.importNode(kid, true);
	        results.appendChild(kid);
	      }
	//    }

	    return base;
	  }

	  public  String print(Document doc) throws Exception {
	    TransformerFactory transformerFactory = TransformerFactory
	        .newInstance();
	    Transformer transformer = transformerFactory
	        .newTransformer();
	    transformer.setOutputProperty("encoding","UTF-8");
	    ByteArrayOutputStream bos = new ByteArrayOutputStream();
	    transformer.transform(new DOMSource(doc), new StreamResult(bos));
	    String xmlStr = bos.toString();
	    return xmlStr;
	  }
	  
	     //读取传入的路径，返回一个document对象
	     public static Document loadInit(String filePath){
	         Document document = null;
	         try{
	             DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	             DocumentBuilder builder = factory.newDocumentBuilder();
	             document = builder.parse(new File(filePath));
	             document.normalize();
	             return document;
	         }catch(Exception e){
	             e.printStackTrace();
	             System.out.println(e.getMessage());
	             return null;
	         }
	     }

//	     /**
//	      * 删除制定的xml
//	      * @param filePath
//	      * @return
//	      */
//	     public static boolean deleteXML(String filePath){
//	         deleteNumber = "421f481e-790c-41be-91e3-27d215b73ce2";
//	         Document document = loadInit(filePath);
//	         try{
//	             NodeList nodeList = document.getElementsByTagName("color");
//	             for(int i=0; i<nodeList.getLength(); i++){
//	                 String number_ = document.getElementsByTagName("number").item(i).getFirstChild().getNodeValue();
//	                 //删除节点时传入的参数
//	                 if(number_.equals(deleteNumber)){
//	                     Node node = nodeList.item(i);
//	                     node.getParentNode().removeChild(node);
//	                     saveXML(document, filePath);
//	                 }
//	             }
//	             return true;
//	         }catch(Exception e){
//	             e.printStackTrace();
//	             System.out.println(e.getMessage());
//	             return false;
//	         }
//	     }
	     
	     /**
	      * 修改制定的xml
	      * @param filePath  xml文件位置
	      * @param defaultFilePath  默认路径参数
	      * @return
	      */
	     public void updateXML(String filePath, String defaultFilePath){
	          //读取传入的路径，返回一个document对象
	          Document document = loadInit(filePath);
	          document.getElementsByTagName("defaultFilePath").item(0).getFirstChild().setNodeValue(defaultFilePath);
	          saveXML(document, filePath);
	     }
	     
	     
	     public String readXMLElement(String filePath, String readElementName){
	         //读取传入的路径，返回一个document对象
	         Document document = loadInit(filePath);
	             String context = document.getElementsByTagName(readElementName).item(0).getFirstChild().getNodeValue();
	             return context;
	    }
//	     
//	     /**
//	      * 添加节点
//	      * @param filePath
//	      * @return
//	      */
//	     public boolean addXML(String filePath){
//	         try{
//	             //读取传入的路径，返回一个document对象
//	             Document document = loadInit(filePath);
//	             //创建叶节点
//	             Element eltColor = document.createElement("color");
//	             Element eltNumber = document.createElement("number");//创建叶节点的第一个元素
//	             Element eltColorValue = document.createElement("colorValue");//创建叶节点的第二个元素
//	             Element eltMinValue = document.createElement("minValue");//创建叶节点的第三个元素
//	             Element eltMaxValue = document.createElement("maxValue");//创建叶节点的第四个元素
//	             Text number_ = document.createTextNode(UUID.randomUUID().toString());//创建叶节点的第一个元素下的文本节点
//	             eltNumber.appendChild(number_);//把该文本节点加入到叶节点的第一个元素里面
//	             Text colorValue_ = document.createTextNode("colorValue");//创建叶节点的第二个元素下的文本节点
//	             eltColorValue.appendChild(colorValue_);//把该文本节点加入到叶节点的第二个元素里面
//	             Text minValue_ = document.createTextNode("100");//创建叶节点的第三个元素下的文本节点
//	             eltMinValue.appendChild(minValue_);//把该文本节点加入到叶节点的第三个元素里面
//	             Text maxValue_ = document.createTextNode("200");//创建叶节点的第四个元素下的文本节点
//	             eltMaxValue.appendChild(maxValue_);//把该文本节点加入到叶节点的第四个元素里面
//	             //把叶节点下的元素加入到叶节点下
//	             eltColor.appendChild(eltNumber);
//	             eltColor.appendChild(eltColorValue);
//	             eltColor.appendChild(eltMinValue);
//	             eltColor.appendChild(eltMaxValue);
//	             //获取根节点
//	             Element eltRoot = document.getDocumentElement();
//	             //把叶节点加入到根节点下
//	             eltRoot.appendChild(eltColor);
//	             //更新修改后的源文件
//	             saveXML(document, filePath);
//	             return true;
//	         }catch(Exception e){
//	             e.printStackTrace();
//	             System.out.println(e.getMessage());
//	             return false;
//	         }
//	     }
	     
	     /**
	      * 把修改后的document写进源文件（更新源文件）
	      * @param document
	      * @param filePath
	      * @return
	      */
	     public boolean saveXML(Document document, String filePath){
	         try{
	             TransformerFactory tFactory = TransformerFactory.newInstance();
	             Transformer transformer = tFactory.newTransformer();
	             
	             DOMSource source = new DOMSource(document);
	             StreamResult result = new StreamResult(new File(filePath));
	             transformer.transform(source, result);
	             return true;
	         }catch(Exception e){
	             e.printStackTrace();
	             System.out.println(e.getMessage());
	             return false;
	         }
	     }
	     
//	     /**
//	      * 获取xml文件的所有记录
//	      * @param filePath
//	      * @return
//	      */
//	     public static List<ColorValue> selectXML(String filePath){
//	          List<ColorValue> colorValueList = new ArrayList<ColorValue>();
//	          try{
//	              //读取传入的路径，返回一个document对象
//	              Document document = loadInit(filePath);
//	              //获取叶节点
//	              NodeList nodeList = document.getElementsByTagName("color");
//	              //遍历叶节点
//	              for(int i=0; i<nodeList.getLength(); i++){
//	                  ColorValue colorValue = new ColorValue();
//	                  String number_ = document.getElementsByTagName("number").item(i).getFirstChild().getNodeValue();
//	                  String colorValue_ = document.getElementsByTagName("colorValue").item(i).getFirstChild().getNodeValue();
//	                  Double minValue_ = Double.parseDouble(document.getElementsByTagName("minValue").item(i).getFirstChild().getNodeValue());
//	                  Double maxValue_ = Double.parseDouble(document.getElementsByTagName("maxValue").item(i).getFirstChild().getNodeValue());
//	                  colorValue.setNumber(number_);
//	                  colorValue.setColorValue(colorValue_);
//	                  colorValue.setMinValue(minValue_);
//	                  colorValue.setMaxValue(maxValue_);
//	                  colorValueList.add(colorValue);
//	              }
//	              return colorValueList;
//	          }catch(Exception e){
//	              e.printStackTrace();
//	              System.out.println(e.getMessage());
//	              return null;
//	          }
//	     }
	  
}



