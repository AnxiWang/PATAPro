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
		//新建文件夹（目录）对话框
		DirectoryDialog folderdlg = new DirectoryDialog(parent);
		//设置文件对话框的标题
		folderdlg.setText("文件选择");
		//设置初始路径
		folderdlg.setFilterPath("SystemDrive");
		//设置对话框提示文本信息
		folderdlg.setMessage("请选择相应的文件夹");
		//打开文件对话框，返回选中文件夹目录
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
		//新建文件对话框，并设置为打开的方式
		FileDialog filedlg = new FileDialog(parent,SWT.OPEN);
		//设置文件对话框的标题
		filedlg.setText("文件选择");
		//设置初始路径
		filedlg.setFilterPath("SystemRoot");
		//打开文件对话框，返回选中文件的绝对路径
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
	        System.out.println("文件：" + filePath + "存在");  
	   		String[] s = filePath.split("\\.");
	   		System.out.println(s[1]);  
	   		return s[1];
	       } 
else 
{  
	           System.out.println("文件：" + f.getPath() + "不存在!");  
	           return null;
	       }
	  }
}