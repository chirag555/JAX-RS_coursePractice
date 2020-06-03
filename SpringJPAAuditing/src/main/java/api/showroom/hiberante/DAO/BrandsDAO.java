package api.showroom.hiberante.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import api.showroom.hibernate.entities.BrandEntity;

public class BrandsDAO {
	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(BrandEntity.class)
			.buildSessionFactory();

	public List<BrandEntity> getBrands() {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<BrandEntity> list = session.createQuery("from brands").getResultList();

		return list;
	}

	public void addBrand(BrandEntity brand) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(brand);
		session.getTransaction().commit();

	}

	public void updateBrand(BrandEntity updatedBrand) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		int id = updatedBrand.getbrandId();
		BrandEntity brand = session.get(BrandEntity.class, id);
		brand.setBrandName(updatedBrand.getBrandName());
		session.getTransaction().commit();
	}

	public void deleteBrand(int brandId) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		BrandEntity brand = session.get(BrandEntity.class, brandId);
		session.delete(brand);
		session.getTransaction().commit();

	}

	public BrandEntity getBrands(int brandId) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		// BrandEntity brand=session.get(BrandEntity.class, brandId);
		return session.get(BrandEntity.class, brandId);

	}

}
