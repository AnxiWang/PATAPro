package config;
import java.io.File;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
//---------------------------------------------------------------------------

public class DirConfig
{
	private String path;
	public String getPath() 
{		
		return path;
	}

	public void setPath(String path) 
{
		this.path = path;
	}
//---------------------------------------------------------------------------	
	public String folderDig(Shell parent)
{
		//�½��ļ��У�Ŀ¼���Ի���
		DirectoryDialog folderdlg = new DirectoryDialog(parent);
		//�����ļ��Ի���ı���
		folderdlg.setText("�ļ�ѡ��");
		//���ó�ʼ·��
		folderdlg.setFilterPath("SystemDrive");
		//���öԻ�����ʾ�ı���Ϣ
		folderdlg.setMessage("��ѡ����Ӧ���ļ���");
		//���ļ��Ի��򣬷���ѡ���ļ���Ŀ¼
		String selecteddir = folderdlg.open();
		if(selecteddir == null)
{
			return null;
		}
		else
{
			return selecteddir;
		}
	}
//---------------------------------------------------------------------------
	
	public String fileDig(Shell parent)
{
		//�½��ļ��Ի��򣬲�����Ϊ�򿪵ķ�ʽ
		FileDialog filedlg = new FileDialog(parent,SWT.OPEN);
		//�����ļ��Ի���ı���
		filedlg.setText("�ļ�ѡ��");
		//���ó�ʼ·��
		filedlg.setFilterPath("SystemRoot");
		//���ļ��Ի��򣬷���ѡ���ļ��ľ���·��
		String selected = filedlg.open();
		if(selected == null)
{
			return null;
		}
		else
{
			return selected;
		}
	}
//---------------------------------------------------------------------------
	
	public String fileTest(String filePath)
{
	    File f = new File(filePath);  
	    if (f.exists())
 {
	        System.out.println("�ļ���" + filePath + "����");  
	   		String[] s = filePath.split("\\.");
	   		System.out.println(s[1]);  
	   		return s[1];
	       } 
else 
{  
	           System.out.println("�ļ���" + f.getPath() + "������!");  
	           return null;
	       }
	  }
}