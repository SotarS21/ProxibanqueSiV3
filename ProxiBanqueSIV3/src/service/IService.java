package service;

import dao.Idao;
import dao.linkDao;

/**
 * @author Jonas Ma�va
 *
 */
public class IService {

	public IService()
	{
		Idao idao = linkDao.getInstance() ;
	}

}
