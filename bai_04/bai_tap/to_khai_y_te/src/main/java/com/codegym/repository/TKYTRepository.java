package com.codegym.repository;

import com.codegym.model.ToKhaiYTe;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TKYTRepository implements ITKYTRepository{
    private static final List<ToKhaiYTe> toKhaiYTeList;
    static {
        toKhaiYTeList = new ArrayList<>();
        toKhaiYTeList.add(new ToKhaiYTe(1,"Cường1","2003",true,"Việt Nam","201862018","Ô tô","5701",4,"1","1","2021","5","1","2021","Không"));
        toKhaiYTeList.add(new ToKhaiYTe(2,"Cường2","2003",true,"Hoa Kỳ","201862018","Tàu bay","5701",4,"1","2","2021","6","2","2021","Không"));
        toKhaiYTeList.add(new ToKhaiYTe(3,"Cường3","2003",true,"Nhật Bản","201862018","Tàu thuyền","5701",4,"1","3","2021","7","3","2021","Không"));
        toKhaiYTeList.add(new ToKhaiYTe(4,"Cường4","2003",true,"Hàn Quốc","201862018","Xe máy","5701",4,"1","4","2021","8","4","2021","Không"));
    }
    @Override
    public List<ToKhaiYTe> findAll() {
        return toKhaiYTeList;
    }

    @Override
    public void save(ToKhaiYTe toKhaiYTe) {
        toKhaiYTeList.add(toKhaiYTe);
    }
}
