package service;

import dao.Idao;
import dao.linkDao;

/**
 * @author Jonas Maëva
 *
 */
public class IService {

	public IService()
	{
		Idao idao = linkDao.getInstance() ;
	}

}
