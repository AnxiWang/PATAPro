package PATAPro;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
//---------------------------------------------------------------------------

public class Analysis
 {
public String analyseData(String filePath)
{
    	try {
			double TotalSendPacket = 0;
			double TotalRecvPacket = 0;
			int highest_packet_id = 0;
			double total_pkt_size = 0;
			double packet_number = 0;
			double pkt_tcp_sum = 0;
			double pkt_route_sum = 0;
			double packet_duration;
			double duration_total = 0;
			int drop_packet;
			int requests;
			int intpkt_id;
			File file1 = new File(filePath);
			File file=new File(filePath.trim());
			String fileName = file.getName(); 
			FileReader fr;
			fr = new FileReader(file1);
			BufferedReader br;
			br = new BufferedReader(fr);
			String aline;
			String stri;
			String event ;
			String trace_type ;
			String pkt_type ;
			String pkt_size;
			String source_ip;
			String pkt_id;
			String time;
			String node;
			double start_time[] = new double[1000000];
			double end_time[] = new double[1000000];
			while((aline= br.readLine())!= null)
			{
				int i=0;
				int count=0;
				if(aline!= null)
				{
					count++;
				}
				String[] myArray = new String[count];
				myArray[i] = aline;

				//���ļ����и�ʽ�ϵĸı䣬Ϊ�˸��õط���
				myArray[i]=myArray[i].replace("_"," ");
				myArray[i]=myArray[i].replace("["," ");
				stri=myArray[i];
				String[] stringA = stri.split(" ");
				event=stringA[0];     //#; Event : r , s , d , f
				if (event.equals("r")||event.equals("s")||event.equals("f"))
				{
				time=stringA[1];     //#; Time : send time , receive time , drop time
				node=stringA[3];     //#; Node : source node , receive node
				trace_type=stringA[5];     //#; Trace type MAC trace
				pkt_id=stringA[8]; //#; Event ID : Frame sequence number for total flows
				pkt_type=stringA[9];     //#; Packet type : RTS , CTS , Data = tcp , ACK
				pkt_size=stringA[10];
									if(event.equals("s")&&trace_type.equals("AGT")&&pkt_type.equals("tcp"))
									{ 
						TotalSendPacket++;
						}
					if(event.equals("r")&&trace_type.equals("AGT")&&pkt_type.equals("tcp"))
					{
						TotalRecvPacket++;
						}
					if(event.equals("r")&&trace_type.equals("AGT")&&pkt_type.equals("tcp"))
					{ 
						pkt_tcp_sum++;
						}
			intpkt_id=Integer.parseInt(pkt_id);
			//ǿ������ת��Ϊ�˲�������
			double doublepkt_size=Double.parseDouble(pkt_size);
	if((event.equals("s")||event.equals("f")) && (trace_type.equals("AGT")) )
	{
						pkt_route_sum++;
					}
				if(event.equals("s")&&trace_type.equals("AGT")&&pkt_type.equals("tcp")&& start_time[intpkt_id]==0 )
				{
						start_time[intpkt_id] = Double.parseDouble(time);
						if ( intpkt_id > highest_packet_id )
							highest_packet_id = intpkt_id;
					}
if (event.equals("r")&&trace_type.equals("AGT")&&pkt_type.equals("tcp") )
	{
						total_pkt_size = total_pkt_size + doublepkt_size;
						end_time[intpkt_id] = Double.parseDouble(time);
					}
				}
			i++;
		}
			for ( int intp = 0; intp <= highest_packet_id; intp++ ){
				double start=0;
				double end=0;
				start = start_time[intp];  
				end = end_time[intp]; 
				if ( end!=-1 && start < end )
{
					packet_duration = end - start;
					duration_total += packet_duration; // total duration
					packet_number++; //count packet number

				}
			}
String result1 = "\nPacket delivery ratio: \n" + String.valueOf(TotalRecvPacket/TotalSendPacket) 
							+ "\nNormalized routing overhead:\n" + String.valueOf(pkt_route_sum/pkt_tcp_sum)
								+ "\nAverage end-to-end delay:\n" + String.valueOf(duration_total / packet_number);
	//��������Ͷ���ʣ�Packet delivery ratio������һ��·�ɿ�����Normalized routing overhead����ƽ���˵���ʱ�ӣ�Average end-to-end delay��
		String result="\t\t\t\t"+fileName+result1;
			fr.close();
//�ر��ļ�������
			br.close();
//�رջ�����
			return result;
//���ؽ��
		}
		catch (IOException ioe)
{		//��׽�쳣
			ioe.printStackTrace();
			return "����ʧ�ܣ�";
			}
}
}