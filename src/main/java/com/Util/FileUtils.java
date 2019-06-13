package com.Util;

import java.io.*;

public class FileUtils {
	/**
	 * 以字节为单位读取文件，常用于读二进制文件，如图片、声音、影像等文件
	 * author:yuantao01@wondersgroup.com
	 * time:2017-9-27
	 * @param fileName
	 * @param type 读取的模式单字节1多字节≠1
	 */
    public static void readFileByBytes(String fileName, int type) {
        File file = new File(fileName);
        InputStream in = null;
        if(type==1){
        	try {
                // 一次读一个字节
                in = new FileInputStream(file);
                int tempbyte;
                while ((tempbyte = in.read()) != -1) {
                    System.out.write(tempbyte);
                }
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
                return;
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e1) {
                    }
                }
            }
        }else{
        	try {
                // 一次读多个字节
                byte[] tempbytes = new byte[100];
                int byteread = 0;
                in = new FileInputStream(fileName);
                FileUtils.showAvailableBytes(in);
                // 读入多个字节到字节数组中，byteread为一次读入的字节数
                while ((byteread = in.read(tempbytes)) != -1) {
                    System.out.write(tempbytes, 0, byteread);
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e1) {
                    }
                }
            }
        }
        
        
    }

   
    /**
     * 以字符为单位读取文件，常用于读文本，数字等类型的文件
     * author:yuantao01@wondersgroup.com
     * time:2017-9-27
     * @param fileName
     * @param type 读取的模式单字节1多字节≠1
     */
    public static void readFileByChars(String fileName, int type) {
        File file = new File(fileName);
        Reader reader = null;
        if(type==1){
        	try {
                // 一次读一个字符
            	InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "UTF-8");
                reader = new BufferedReader(isr);
                int tempchar;
                while ((tempchar = reader.read()) != -1) {
                    // 对于windows下，\r\n这两个字符在一起时，表示一个换行。
                    // 但如果这两个字符分开显示时，会换两次行。
                    // 因此，屏蔽掉\r，或者屏蔽\n。否则，将会多出很多空行。
                    if (((char) tempchar) != '\r') {
                        System.out.print((char) tempchar);
                    }
                }
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e1) {
                    }
                }
            }
        }else{
        	try {
                System.out.println("以字符为单位读取文件内容，一次读多个字节：");
                // 一次读多个字符
                char[] tempchars = new char[30];
                int charread = 0;
            	InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "UTF-8");
                reader = new BufferedReader(isr);
                // 读入多个字符到字符数组中，charread为一次读取字符数
                while ((charread = reader.read(tempchars)) != -1) {
                    // 同样屏蔽掉\r不显示
                    if ((charread == tempchars.length)
                            && (tempchars[tempchars.length - 1] != '\r')) {
                        System.out.print(tempchars);
                    } else {
                        for (int i = 0; i < charread; i++) {
                            if (tempchars[i] == '\r') {
                                continue;
                            } else {
                                System.out.print(tempchars[i]);
                            }
                        }
                    }
                }

            } catch (Exception e1) {
                e1.printStackTrace();
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e1) {
                    }
                }
            }
        }
        
        
    }


    /**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     * author:yuantao01@wondersgroup.com
     * time:2017-9-27
     * @param fileName
     */
    public static void readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
        	InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "UTF-8");
            reader = new BufferedReader(isr);
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                System.out.println("line " + line + ": " + tempString);
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }

    /**
     * 随机读取文件内容
     */
    public static void readFileByRandomAccess(String fileName) {
        RandomAccessFile randomFile = null;
        try {
            System.out.println("随机读取一段文件内容：");
            // 打开一个随机访问文件流，按只读方式
            randomFile = new RandomAccessFile(fileName, "r");
            // 文件长度，字节数
            long fileLength = randomFile.length();
            // 读文件的起始位置
            int beginIndex = (fileLength > 4) ? 4 : 0;
            // 将读文件的开始位置移到beginIndex位置。
            randomFile.seek(beginIndex);
            byte[] bytes = new byte[10];
            int byteread = 0;
            // 一次读10个字节，如果文件内容不足10个字节，则读剩下的字节。
            // 将一次读取的字节数赋给byteread
            while ((byteread = randomFile.read(bytes)) != -1) {
                System.out.write(bytes, 0, byteread);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (randomFile != null) {
                try {
                    randomFile.close();
                } catch (IOException e1) {
                }
            }
        }
    }

    /**
     * 显示输入流中还剩的字节数
     */
    private static void showAvailableBytes(InputStream in) {
        try {
            System.out.println("当前字节输入流中的字节数为:" + in.available());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * FileWriter写文件，用于写文字类的文件
     * author:yuantao01@wondersgroup.com
     * time:2017-9-27
     * @param content
     * @param fileName
     */
    public static void writeFileByWritter(String content , String fileName){
        FileWriter writer;
        try {
            writer = new FileWriter(fileName);
            writer.write(content);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 使用流处理写入文件，通常用来处理图像的写入工作
     * author:yuantao01@wondersgroup.com
     * time:2017-9-27
     * @param str
     * @param fileName
     */
    public static void writeFileByStream(String str, String fileName){
    	File txt=new File(fileName);
    	FileOutputStream fos=null;
        try {
        	if(!txt.exists()){  
                  txt.createNewFile();  
             }  
              byte bytes[]=new byte[512];   
              bytes=str.getBytes();  
              int b=bytes.length;   //是字节的长度，不是字符串的长度
              fos=new FileOutputStream(txt);
			fos.write(bytes,0,b);
			fos.write(bytes);
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
    }
    /**
     * 在文件后追加字符串
     * author:yuantao01@wondersgroup.com
     * time:2017-9-28
     * @param str
     * @param fileName
     */
    public static void writeFileConcat(String str, String fileName){
    	try {
    		FileOutputStream fos = new FileOutputStream(fileName,true);
        	//true表示在文件末尾追加  
			fos.write(str.getBytes());
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}  
    	
    }
    /**
     * 采用递归的方式实现遍历文件夹下的所有文件
     * author:yuantao01@wondersgroup.com
     * time:2017-12-7
     * @param path
     */
	public void traverseFolder(String path) {
		File file = new File(path);
		if (file.exists()) {
			File[] files = file.listFiles();
			if (files.length == 0) {
				System.out.println("文件夹是空的!");
				return;
			} else {
				for (File file2 : files) {
					if (file2.isDirectory()) {
						System.out.println("文件夹:" + file2.getAbsolutePath());
						traverseFolder(file2.getAbsolutePath());
					} else {
						System.out.println("文件:" + file2.getAbsolutePath());
					}
				}
			}
		} else {
			System.out.println("文件不存在!");
		}
	}  
    
 
    
    public static void main(String[] args) {
        String fileName = "Y:/newTemp.txt";
        /*FileUtils.readFileByBytes(fileName,1);
        FileUtils.readFileByChars(fileName,1);
        FileUtils.readFileByLines(fileName);
        FileUtils.readFileByRandomAccess(fileName);*/
FileUtils.writeFileConcat("contact", fileName);
    }
}
