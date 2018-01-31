package com.bstek.dorado.sample.standardlesson.dao;
import org.springframework.stereotype.Repository;
import com.bstek.dorado.hibernate.HibernateDao;
import com.bstek.dorado.sample.standardlesson.entity.SlMenu;
@Repository
public class SlMenuDao extends HibernateDao<SlMenu, Long> {
}
