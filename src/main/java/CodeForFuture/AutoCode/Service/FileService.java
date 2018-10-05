package CodeForFuture.AutoCode.Service;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.log4j.Logger;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import CodeForFuture.AutoCode.Resources.GolbalConfig;


@Service
public class FileService {
	
	private final static Logger logger =  Logger.getLogger(FileService.class);

	public Path load(String filename) {
		return Paths.get(GolbalConfig.Generator_Dir.getContext()).resolve(filename);
	}

	public Resource loadAsResource(String filename) {
		try {
			Path file = load(filename);
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			}
			else {
				logger.error("Could not read file: " + filename);
				throw new RuntimeException(
						"Could not read file: " + filename);
			}
		}
		catch (MalformedURLException e) {
			logger.error("Could not read file: " + filename,e);
			throw new RuntimeException("Could not read file: " + filename, e);
		}
	}

}
